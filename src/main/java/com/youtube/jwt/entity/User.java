package com.youtube.jwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User
{
    @Id
    private  String userName;
    private  String userFirstName;
    private  String userLastName;
    private  String userPassword;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinTable(name="USER_ROLE",
   joinColumns = {
           @JoinColumn(name = "USER_ID")
   },
   inverseJoinColumns = {
           @JoinColumn(name = "ROLE_ID")
   })

    private Set<Role> role;
}
