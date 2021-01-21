package com.dash14.service;

import java.util.List;

import com.dash14.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("playerService")
public class PlayerService 
{
    @Autowired
    private PlayerRepository playerRepository;

    public Player getPlayer(Long id)
    {
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> getAllPlayers() 
    {
        return playerRepository.findAll();
    }

    public Player savePlayer(final Player player)
    {
        return playerRepository.save(player);
    }

    public Player updatePlayer(final Player player, final Long id) {
        final Player newPlayer = playerRepository.findById(id).orElse(null);

        if (newPlayer != null) 
        {
            newPlayer.setFirstName(player.getFirstName());
            newPlayer.setLastName(player.getLastName());
        }

        final Player updatedPlayer = playerRepository.save(newPlayer);

        return updatedPlayer;
    }

    public Boolean deletePlayer (final Long id)
    {
        final Player delPlayer = playerRepository.findById(id).orElse(null);

        if (delPlayer != null)
        {
            playerRepository.delete(delPlayer);

            return true;
        }

        return false;
    }
}