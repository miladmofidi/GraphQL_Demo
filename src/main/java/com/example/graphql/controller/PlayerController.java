package com.example.graphql.controller;

import com.example.graphql.model.Club;
import com.example.graphql.model.Player;
import com.example.graphql.model.Team;
import com.example.graphql.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/**
 * @author Milad Mofidi (milad.mofidi@cmas-systems.com)
 * 2/5/2024
 */
@Controller
@RequiredArgsConstructor
public class PlayerController {
	private final PlayerService playerService;

	@QueryMapping
	public List<Player> findAllPlayer() {
		return playerService.findAll();
	}

	@QueryMapping
	public Optional<Player> findOnePlayer(@Argument Integer id){
		return playerService.findOne(id);
	}

	@MutationMapping
	public Player create( @Argument String name, @Argument Team team, @Argument Club club) {
		return playerService.create(name, team, club);
	}

	@MutationMapping
	public Player update( @Argument Integer id, @Argument String name, @Argument Team team, @Argument Club club) {
		return playerService.update(id, name, team, club);
	}

	@MutationMapping
	public Player delete( @Argument Integer id ) {
		return playerService.delete(id);
	}

}
