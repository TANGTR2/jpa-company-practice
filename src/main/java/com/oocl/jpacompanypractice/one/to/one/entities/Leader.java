package com.oocl.jpacompanypractice.one.to.one.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table
@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klass_id")
    private Klass klass;

    public Leader(){}

    public Leader(String name, Klass klass) {
        this.name = name;
        this.klass = klass;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Klass getKlass() { return klass; }
    public void setKlass(Klass klass) { this.klass = klass; }
}
