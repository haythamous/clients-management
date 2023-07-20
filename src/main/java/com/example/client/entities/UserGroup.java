package com.example.client.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "USERS_GROUPS")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_GROUP_ID")
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "GROUP_ID")
    @JsonBackReference
    private Group group;

    private boolean activated;

    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
