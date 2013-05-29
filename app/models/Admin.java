package models;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.05.13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password_hash")
    private String password_hash;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password) {
        this.password_hash = password;
    }
}
