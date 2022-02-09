package com.codekage.pma.entities;



import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @SequenceGenerator(name = "user_accounts_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_accounts_seq", strategy=SEQUENCE)
    @Column(name = "user_id")
    private long userId;


    @Column(name = "username")
    private String userName;

    private String email;
    private String password;
    private String role;
    private boolean enabled = true;

    public UserAccount() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
