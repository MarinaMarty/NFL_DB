package com.promineo.NFL.repository;
//old
import org.springframework.data.jpa.repository.JpaRepository;

import com.promineo.NFL.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
//done!!
}
