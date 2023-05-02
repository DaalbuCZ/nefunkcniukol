package cz.daalbu.usercore.privateMsg.command;

import cz.daalbu.usercore.UserCore;
import cz.daalbu.usercore.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PmToggle implements CommandExecutor {

    private UserCore plugin;

    public PmToggle(){
        this.plugin = UserCore.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTento příkaz mohou zadat pouze hráči!");
            return true;
        }

        Player player = (Player) sender;
        User user = plugin.getUserManager().loadUser(player.getName());

        if (user.getPmState()) {
            user.setPmState(false);
            plugin.getUserManager().saveUser(user);
            return true;
        }

        user.setPmState(true);
        plugin.getUserManager().saveUser(user);
        return true;
    }

}