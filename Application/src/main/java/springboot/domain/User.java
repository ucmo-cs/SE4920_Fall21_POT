package springboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    /*
    Id : int unique identifier
    Email: varchar
    Username : varchar
    Password : varchar
    Priority : integer
    Locked: boolean
    Online : boolean
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int priority;
    @Column
    private int locked;
    @Column
    private int online;

    public User(int id, String email, String username, String password, int priority, int locked, int online) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.priority = priority;
        this.locked = locked;
        this.online = online;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", priority='" + priority + '\'' +
                ", locked='" + Utility.toBoolean(locked) + '\'' +
                ", online='" + Utility.toBoolean(online) + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}