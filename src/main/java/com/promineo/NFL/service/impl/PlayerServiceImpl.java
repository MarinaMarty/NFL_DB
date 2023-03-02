package com.promineo.NFL.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.NFL.exception.ResourceNotFoundException;
import com.promineo.NFL.model.Player;
import com.promineo.NFL.repository.PlayerRepository;


@Service
public class PlayerServiceImpl implements PlayerService {
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	
	//get all generic
	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	//get by a specific ID
	@Override
	public Player getPlayerByID(int id) {
		return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", id));
	}
	//posting a player
	@Override
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	
	@Override
	public Player updatePlayer(Player player, int Id) {
		Player existingPlayer = playerRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", Id));
		
		existingPlayer.setFirst_name(player.getFirst_name());
		existingPlayer.setLast_name(player.getLast_name());
		existingPlayer.setTeam_id(player.getTeam_id());
		
		return existingPlayer;
	}

	
	public void deletePlayer(int Id) {
		Player existingPlayer = playerRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", Id));
		playerRepository.deleteById(Id);
	}

	
	
	
	
	
}
