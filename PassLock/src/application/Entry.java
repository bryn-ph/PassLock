package application;

import java.io.Serializable;

public class Entry implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String platform;
    private String username;
    private String password;

    public Entry(String platform, String username, String password) {
        this.platform = platform;
        this.username = username;
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
