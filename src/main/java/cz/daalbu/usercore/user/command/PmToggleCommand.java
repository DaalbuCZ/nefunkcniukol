package cz.daalbu.usercore.user.command;

import cz.daalbu.usercore.UserCore;
import cz.daalbu.usercore.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PmToggleCommand implements CommandExecutor {
    private UserCore plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTento příkaz mohou zadat pouze hráči!");
            return true;
        }
        Player player = (Player) sender;
        String userName = sender.getName();
        return true;
    }
    public String getUsername(String userName){
        return userName;
    }
}
