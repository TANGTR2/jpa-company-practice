package com.oocl.jpacompanypractice.one.to.one.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table
@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "klass",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_name")
    private Leader leader;

    public Klass(){}

    public Klass(String name, Leader leader) {
        this.name = name;
        this.leader = leader;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Leader getLeader() { return leader; }
    public void setLeader(Leader leader) { this.leader = leader; }
}
