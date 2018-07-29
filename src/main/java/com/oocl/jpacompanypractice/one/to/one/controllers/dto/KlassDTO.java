package com.oocl.jpacompanypractice.one.to.one.controllers.dto;

import com.oocl.jpacompanypractice.one.to.one.entities.Klass;

public class KlassDTO {
    private final Long id;
    private final String name;
    private final String leaderName;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLeaderName() { return leaderName; }

    public KlassDTO(Klass klass){
        this.id = klass.getId();
        this.name = klass.getName();
        this.leaderName = klass.getLeader().getName();
    }
}
