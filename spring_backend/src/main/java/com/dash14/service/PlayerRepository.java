package com.dash14.service;

import com.dash14.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PlayerRepository")
public interface PlayerRepository extends JpaRepository<Player, Long> 
{
   
}