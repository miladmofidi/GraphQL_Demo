package com.example.graphql.service;

import com.example.graphql.model.Club;
import com.example.graphql.model.Player;
import com.example.graphql.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Milad Mofidi (milad.mofidi@cmas-systems.com)
 * 2/5/2024
 */
@Service
public class PlayerService {

	private List<Player> players = new ArrayList<>();
	AtomicInteger id = new AtomicInteger(0);

	public List<Player> findAll() {
		return players;
	}

	public Optional<Player> findOne(Integer id) {
		return players.stream().filter( player -> player.Id() == id ).findFirst();
	}

	public Player create(String name, Team team, Club club){
		Player player = new Player( id.incrementAndGet(), name, team, club );
		players.add( player );
		return player;
	}

	public Player delete(Integer id){
		Player player = players.stream().filter( plyer -> plyer.Id() == id ).findFirst().orElseThrow( () -> new IllegalArgumentException("Player not found") ) ;;
		players.remove( player );
		return player;
	}

	public Player update(Integer id, String name, Team team, Club club){
		Player updatedPlayer = new Player( id, name, team, club );
		Optional<Player> optional = players.stream().filter( plyer -> plyer.Id() == id ).findFirst();
		if ( optional.isPresent() ){
			Player player = optional.get();
			int index = players.indexOf( player );
			players.set( index, updatedPlayer );
		} else{
			throw new IllegalArgumentException("Invalid Player");
		}
		return updatedPlayer;
	}


	@PostConstruct
	void init(){
		players.add( new Player(id.incrementAndGet() , "Mathew Daniela", Team.MI, new Club( 1 , "Barcelona" ) ) );
		players.add( new Player(id.incrementAndGet() , "Douglas Bio", Team.DC, new Club( 2 , "Madrid" )  ) );
		players.add( new Player(id.incrementAndGet() , "George Miller", Team.CSK , new Club( 3 , "Getafe" ) ) );
	}

}
