package com.dash14.controller;

import com.dash14.model.Player;
import com.dash14.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PlayerController
{
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> all() 
    {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable Long id)
    {
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer (@Valid @RequestBody final Player player) {
        return ResponseEntity.ok(playerService.savePlayer(player));
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(@Valid @RequestBody final Player player,
            @PathVariable(value = "id") long id) {
        return ResponseEntity.ok(playerService.updatePlayer(player, id));
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable final Long id) {
        final Map<String, String> response = new HashMap<String, String>();

        if (playerService.deletePlayer(id))
        {
            response.put("status", "success");
            response.put("message", "member deleted successfully");
            return ResponseEntity.ok(response);
        }
        else
        {
            response.put("status", "error");
            response.put("message", "Something went wrong trying to delete member " + id);
            return ResponseEntity.status(500).body(response);
        }
    }
}