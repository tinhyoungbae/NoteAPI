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
    //@ManyToMany(mappedBy = "user1IsFriend")
    Set<User> isFriendUser1;

    // foreign key between Text and User
    @Column(name = "user2ID")
    //@ManyToMany(mappedBy = "user2IsFriend")
    Set<User> isFriendUser2;

    public isFriend(){

    }

    public isFriend(int isFriendID, boolean isFriendRule, Set<User> isFriendUser1, Set<User> isFriendUser2) {
        this.isFriendID = isFriendID;
        this.isFriendRule = isFriendRule;
        this.isFriendUser1 = isFriendUser1;
        this.isFriendUser2 = isFriendUser2;
    }

    public int getIsFriendID() {
        return isFriendID;
    }

    public void setIsFriendID(int isFriendID) {
        this.isFriendID = isFriendID;
    }

    public boolean isFriendRule() {
        return isFriendRule;
    }

    public void setFriendRule(boolean friendRule) {
        isFriendRule = friendRule;
    }

    public Set<User> getIsFriendUser1() {
        return isFriendUser1;
    }

    public void setIsFriendUser1(Set<User> isFriendUser1) {
        this.isFriendUser1 = isFriendUser1;
    }

    public Set<User> getIsFriendUser2() {
        return isFriendUser2;
    }

    public void setIsFriendUser2(Set<User> isFriendUser2) {
        this.isFriendUser2 = isFriendUser2;
    }
}
