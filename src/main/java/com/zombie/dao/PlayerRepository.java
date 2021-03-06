package com.zombie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zombie.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	Player findByPlayerid(int id);
	List<Player> findBySpecies(String species);
}
