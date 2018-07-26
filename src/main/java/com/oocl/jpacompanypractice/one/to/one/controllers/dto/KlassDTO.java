package com.oocl.jpacompanypractice.one.to.one.controllers.dto;

import com.oocl.jpacompanypractice.one.to.one.entities.Klass;

public class KlassDTO {
    private final Long id;
    private final String name;
    private final Long leaderId;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Long getLeaderId() { return leaderId; }

    public KlassDTO(Klass klass){
        this.id = klass.getId();
        this.name = klass.getName();
        this.leaderId = klass.getLeader().getId();
    }
}
