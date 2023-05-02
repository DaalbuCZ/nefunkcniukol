package cz.daalbu.usercore.user.listener;

import cz.daalbu.usercore.UserCore;
import cz.daalbu.usercore.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private UserCore core;

    public JoinListener() {
        this.core = UserCore.getInstance();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        User user = core.getUserManager().loadUser(player.getName());

        player.sendMessage("Funguje to!");
    }




}
