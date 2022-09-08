package me.failures.main;

import org.bukkit.plugin.java.JavaPlugin;

public class HealthScaler extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("HealthScaler has been enabled.");
        getServer().getPluginManager().registerEvents(new ScaleListener(this),this);
    }

    @Override
    public void onDisable() {}
}
