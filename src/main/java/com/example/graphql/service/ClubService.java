package com.example.graphql.service;

import com.example.graphql.model.Club;
import com.example.graphql.model.Player;
import com.example.graphql.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ClubService {
	public static List<Club> clubs = new ArrayList<>();

	@PostConstruct
	void init(){
		clubs.add( new Club( 1 , "Barcelona" ) )  ;
		clubs.add( new Club( 2 , "Madrid" )  );
		clubs.add( new Club( 3 , "NY" )  ) ;
	}

}
