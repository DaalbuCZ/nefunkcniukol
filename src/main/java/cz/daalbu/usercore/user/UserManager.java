package cz.daalbu.usercore.user;

import cz.daalbu.usercore.UserCore;
import cz.daalbu.usercore.user.command.PmToggleCommand;
import cz.daalbu.usercore.user.listener.JoinListener;

import java.util.HashMap;

public class UserManager {
    private UserCore plugin;
    private HashMap<String, User> userHashMap = new HashMap<>();

    public UserManager(){
        this.plugin.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
        this.plugin.getCommand("pmToggle").setExecutor(new PmToggleCommand());
        this.saveUser();
        this.loadUserOnJoin();

    }


    public void saveUser(){
        String userName = new JoinListener().toString().toLowerCase();
        if (!userHashMap.containsKey(userName.toLowerCase())){
            User user = new User(userName, true);
            userHashMap.put(userName, user);
        }
    }
    public User loadUserOnJoin(){
        String userName = new JoinListener().toString().toLowerCase();
        if (userHashMap.containsKey(userName.toLowerCase())) {
            User user = userHashMap.get(userName.toLowerCase());
            return user;
        }
        return null;
    }
    public User loadUser(String userName){
        if (userHashMap.containsKey(userName.toLowerCase())) {
            User user = userHashMap.get(userName.toLowerCase());
            return user;
    }
        return null;
}