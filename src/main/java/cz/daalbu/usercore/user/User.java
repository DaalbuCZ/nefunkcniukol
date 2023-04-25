package cz.daalbu.usercore.user;

public class User {
    private String name;
    private boolean pmState;

    public User(String name, boolean pmState) {
        this.name = name;
        this.pmState = pmState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPmState() {
        return pmState;
    }

    public void setPmState(boolean pmState) {
        this.pmState = pmState;
    }
}

