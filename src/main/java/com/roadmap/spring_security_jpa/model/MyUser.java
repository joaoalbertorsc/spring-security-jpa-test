package com.roadmap.spring_security_jpa.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Boolean active;
    private String password;
    private String userName;
    private String roles;

//    public void setRoles(List<String> roles) {
//        this.roles = String.join(",", roles);
//    }
}
