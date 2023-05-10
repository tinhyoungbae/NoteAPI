package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "isFriend")
public class isFriend implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isFriendID")
    private int isFriendID;

    @Column(name = "isFriendRule")
    private boolean isFriendRule;

    // foreign key between Text and User
    @Column(name = "user1ID")
    @ManyToMany(mappedBy = "user1IsFriend")
    Set<User> isFriendUser1;

    // foreign key between Text and User
    @Column(name = "user2ID")
    @ManyToMany(mappedBy = "user2IsFriend")
    Set<User> isFriendUser2;

    public isFriend(){

    }
}
