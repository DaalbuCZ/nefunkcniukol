package cz.daalbu.usercore;

import org.bukkit.plugin.java.JavaPlugin;

public final class UserCore extends JavaPlugin {

    private static UserCore instance;

    @Override
    public void onEnable() {
        instance = this;


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
