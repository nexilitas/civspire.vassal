package org.civspire;

// For future reference, need to import classes l8r
import org.bukkit.plugin.java.JavaPlugin;

public final class civSpireVassal extends JavaPlugin {

    private static civSpireVassal instance;

    private static GroupManager groupManager;

    private static PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        groupManager = new GroupManager();
        playerManager = new PlayerManager();

        VassalAPI.initialize(groupManager, playerManager);

        getLogger().info("Vassal enabled.");
    }

    @Override
    public void onDisable() {
        playerManager.saveAll();
        groupManager.saveAll();
        getLogger().info("Vassal disabled.");
    }

    public static civSpireVassal getInstance() {
        return instance;
    }

    public static GroupManager getGroupManager() {
        return groupManager;
    }

    public PlayerManager getPlayerDataManager() {
        return playerManager;
    }
}