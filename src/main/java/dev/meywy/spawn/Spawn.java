package dev.meywy.spawn;

import dev.meywy.spawn.commands.SetSpawnCommand;
import dev.meywy.spawn.commands.SpawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Successfully Loaded");

        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Successfully unLoaded");
    }
}
