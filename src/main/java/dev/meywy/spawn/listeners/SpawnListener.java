package dev.meywy.spawn.listeners;

import dev.meywy.spawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.EventListener;

public class SpawnListener implements EventListener {

    private final Spawn main;

    public SpawnListener(Spawn main) {
        this.main = main;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (!e.getPlayer().hasPlayedBefore()) {
            Location location = main.getConfig().getLocation("spawn");

            if (location != null) {

                player.teleport(location);

            }

        }

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        Location location = main.getConfig().getLocation("spawn");

        if (location != null) {
            player.teleport(location);
        }

    }

}
