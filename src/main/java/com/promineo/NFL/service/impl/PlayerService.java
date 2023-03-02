package com.promineo.NFL.service.impl;

import java.util.List;

import com.promineo.NFL.model.Player;

public interface PlayerService {
	//oour crud methods are going to placed
	
	//gonna get everyone!!! READ
	public List<Player> getAllPlayers();
	
	//specific, looking by player ID, READ
	public Player getPlayerByID(int id);
	
	//Post a player, CREATE
	public Player savePlayer(Player player);
	
	//Update a player, UPDATE
	public Player updatePlayer(Player player, int Id);
	
	//Delete a player, DELETE
	public void deletePlayer(int Id);
	
	
}
