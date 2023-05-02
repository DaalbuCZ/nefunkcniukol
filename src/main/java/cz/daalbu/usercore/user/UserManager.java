package cz.daalbu.usercore.user;

import cz.daalbu.usercore.UserCore;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class UserManager {
    private UserCore plugin;
    private HashMap<String, User> userHashMap;

    public UserManager(){
        this.plugin = UserCore.getInstance();
        load();
    }

    public void load() {
        userHashMap = new HashMap<>();
    }

    public User createUser(String name, boolean pmToggle) {
        User user = new User(name, pmToggle);
        userHashMap.put(user.getName().toLowerCase(), user);
        return user;
    }

    public User loadUser(String name){
        if (userHashMap.containsKey(name.toLowerCase())) {
            return getUserByName(name);
        }
        return createUser(name, true);
    }

    public User saveUser(User user) {
        String name = user.getName().toLowerCase();
        if (userHashMap.containsKey(name)) {
            userHashMap.replace(name, user);
            return userHashMap.get(name);
        }
        return createUser(name, true);
    }

    public User getUserByName(String name) {
        return userHashMap.get(name.toLowerCase());
    }

    public User getUserByPlayer(Player player) {
        return userHashMap.get(player.getName().toLowerCase());
    }

    public HashMap<String, User> getAllUsers() {
        return userHashMap;
    }



}