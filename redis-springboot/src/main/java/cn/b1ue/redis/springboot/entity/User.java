package cn.b1ue.redis.springboot.entity;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/9 17:01
 */
public class User {

    private String username;
    private String password;
    private String lastLoginTime;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }
}
