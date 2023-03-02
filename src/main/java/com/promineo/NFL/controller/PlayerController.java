package com.promineo.NFL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.NFL.model.Player;
import com.promineo.NFL.service.impl.PlayerService;

@RestController
@RequestMapping("/NFL_DB/player")
public class PlayerController {

	private PlayerService playerService;
	@Autowired
	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	@GetMapping
	public List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	@GetMapping("{player_id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("player_id") int playerId){
		return new ResponseEntity<Player>(playerService.getPlayerByID(playerId), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
	}
	
	@PutMapping("{player_id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("player_id") int playerId, @RequestBody Player player){
		return new ResponseEntity<Player>(playerService.updatePlayer(player, playerId), HttpStatus.OK);
	}
	
	@DeleteMapping("{player_id}")
	public ResponseEntity<String> deletePlayer(@PathVariable("player_id") int playerId){
		playerService.deletePlayer(playerId);
		return new ResponseEntity<String>("Player Gone!!!", HttpStatus.OK);
		
	}
	
	
	
}
