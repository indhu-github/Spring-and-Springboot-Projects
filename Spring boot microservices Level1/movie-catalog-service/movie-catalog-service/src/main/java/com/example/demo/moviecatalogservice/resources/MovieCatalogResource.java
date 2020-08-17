package com.example.demo.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.moviecatalogservice.models.CatalogItem;
import com.example.demo.moviecatalogservice.models.Movie;
import com.example.demo.moviecatalogservice.models.Rating;
import com.example.demo.moviecatalogservice.models.UserRating;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		UserRating ratings=restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId,UserRating.class);
		
		return ratings.getUserRating().stream().map(rating->{
			//For each movieId call movie info service and get details
			Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
			//put them all together
			return new CatalogItem(movie.getName(),"Action",rating.getRating());
		})
	.collect(Collectors.toList());
		}
	
	
}


/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/