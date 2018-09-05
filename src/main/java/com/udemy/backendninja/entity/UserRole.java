package com.udemy.backendninja.entity;


import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.persistence.*;

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true, nullable = false)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username") // Nombre de la tabla a la que se va a unir
    private User user;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
