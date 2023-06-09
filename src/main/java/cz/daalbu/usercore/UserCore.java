package cz.daalbu.usercore;

import cz.daalbu.usercore.privateMsg.command.PmToggle;
import cz.daalbu.usercore.privateMsg.command.PrivateMSG;
import cz.daalbu.usercore.user.UserManager;
import cz.daalbu.usercore.user.listener.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class UserCore extends JavaPlugin {

    private static UserCore instance;

    private UserManager userManager;

    @Override
    public void onEnable() {
        instance = this;

        userManager = new UserManager();


        this.getServer().getPluginManager().registerEvents(new JoinListener(), instance);
        this.getCommand("pmToggle").setExecutor(new PmToggle());
        this.getCommand("pm").setExecutor(new PrivateMSG());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //swag of a mystic lol xdd
        /*   ________  _  _______     ____
            /  ___/\ \/ \/ /\__  \   / ___\
            \___ \  \     /  / __ \_/ /_/  >
           /______>  \/\_/  (______/\___  /
                                   /_____/

                      _____                    _____        _____
                     /\    \                  /\    \      |\    \
                    /::\    \                /::\____\     |:\____\
                   /::::\    \              /:::/    /     |::|   |
                  /::::::\    \            /:::/    /      |::|   |
                 /:::/\:::\    \          /:::/    /       |::|   |
                /:::/__\:::\    \        /:::/    /        |::|   |
               /::::\   \:::\    \      /:::/    /         |::|   |
              /::::::\   \:::\    \    /:::/    /          |::|___|______
             /:::/\:::\   \:::\    \  /:::/    /           /::::::::\    \
            /:::/  \:::\   \:::\____\/:::/____/           /::::::::::\____\
            \::/    \:::\   \::/    /\:::\    \          /:::/~~~~/~~
             \/____/ \:::\   \/____/  \:::\    \        /:::/    /
                      \:::\    \       \:::\    \      /:::/    /
                       \:::\____\       \:::\    \    /:::/    /
                        \::/    /        \:::\    \   \::/    /
                         \/____/          \:::\    \   \/____/
                                           \:::\    \
                                            \:::\____\
                                             \::/    /
                                              \/____/
        */
    }

    public static UserCore getInstance() {
        return instance;
    }

    public UserManager getUserManager() {
        return userManager;
    }

}
