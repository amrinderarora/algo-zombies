package com.zombie.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zombie.dao.PlayerDao;
import com.zombie.entities.Player;

/**
 * @author Jian Luan
 */
@Controller
@RequestMapping("/players")
public class PlayerController {
 
	@Autowired
	private PlayerDao playerDao;

	@RequestMapping("/home")
	public ModelAndView playersHome() {
		List<Player> players = playerDao.getAllPlayers();
		ModelAndView model = new ModelAndView("home");
		model.addObject("players", players);
		return model;
	}
	
	/** Returns JSON String */
	@ResponseBody
	@RequestMapping("/get")
	public List<Player> playersHomeRest() {
		List<Player> players = playerDao.getAllPlayers();
		return players;
	}

	@RequestMapping("/addPlayer")
	public ModelAndView addPlayer(String name, String species, int points, double locationx, double locationy, long createts){
		Player player = new Player();
		player.setName(name);
		player.setSpecies(species);
		player.setPoints(points);
		player.setLocationx(locationx);
		player.setLocationy(locationy);
		//player.setCreatets(createts);
		playerDao.addPlayer(player);
		List<Player> players = playerDao.getAllPlayers();
		ModelAndView model = new ModelAndView("home");
		model.addObject("players", players);
		return model;
	}

	@RequestMapping("/map")
	public String map() {
		return "map";
	}
}