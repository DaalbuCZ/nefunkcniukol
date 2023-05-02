package cz.daalbu.usercore.privateMsg.command;

import cz.daalbu.usercore.UserCore;
import cz.daalbu.usercore.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivateMSG implements CommandExecutor {

    private UserCore plugin;

    public PrivateMSG(){
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

        if (args.length < 2 ) {
            player.sendMessage("HEJ ČAVO NAUČ SE TO POUŽÍVAT!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        User targetUser = plugin.getUserManager().loadUser(target.getName());

        if (!targetUser.getPmState()) {
            player.sendMessage("Borec se nechce bavit Nitram ho má malého");
            return true;
        }

        String message = "";
        for (int i = 1; i < args.length; i++) {
            String a = args[i] + " ";

            message = message + a;
        }

        player.sendMessage("TY >> JEMU: " + message);
        player.sendMessage("ON >> TOBĚ: " + message);
        return true;
    }
}
