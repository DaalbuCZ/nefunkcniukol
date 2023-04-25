package cz.daalbu.usercore;

import cz.daalbu.usercore.user.UserManager;
import cz.daalbu.usercore.user.command.PmToggleCommand;
import cz.daalbu.usercore.user.listener.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class UserCore extends JavaPlugin {

    private static UserCore instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new JoinListener(), instance);
        this.getCommand("pmToggle").setExecutor(new PmToggleCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
