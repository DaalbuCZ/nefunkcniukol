package cz.daalbu.usercore.user.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public String onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String userName = player.getName();
        return userName;
    }

}
