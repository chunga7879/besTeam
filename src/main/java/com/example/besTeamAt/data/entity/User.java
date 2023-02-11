package com.example.besTeamAt.data.entity;


import com.example.besTeamAt.data.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

//    @Enumerated(EnumType.STRING)
//    @Column
//    private UserRole userRole;

    // cascade -> chaing parent => chaning child
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();


//    @Builder
//    public User(Long id, String name, String email, String password, UserRole userRole) {
//        this.id = id;
//        this.email = email;
//        this.name = name;
//        this.password = password;
//        this.userRole = userRole;
//    }

    @Builder
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public UserDto toDto(){
        return UserDto.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

}
