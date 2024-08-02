package dev.meywy.spawn;

import dev.meywy.spawn.commands.SetSpawnCommand;
import dev.meywy.spawn.commands.SpawnCommand;
import dev.meywy.spawn.listeners.SpawnListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Successfully Loaded");

        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        Bukkit.getPluginManager().registerEvents(new SpawnListener(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Successfully unLoaded");
    }
}
