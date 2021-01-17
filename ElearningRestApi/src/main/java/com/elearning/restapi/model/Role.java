package com.elearning.restapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.elearning.restapi.utils.ERole;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    
    @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> user;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

}
