package com.oocl.jpacompanypractice.one.to.one.controllers;

import com.oocl.jpacompanypractice.one.to.one.entities.Klass;
import com.oocl.jpacompanypractice.one.to.one.entities.Leader;
import com.oocl.jpacompanypractice.one.to.one.repositories.KlassRepository;
import com.oocl.jpacompanypractice.one.to.one.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private KlassRepository klassRepository;
    private LeaderRepository leaderRepository;

    @Autowired
    public Controller(KlassRepository klassRepository, LeaderRepository leaderRepository) {
        this.klassRepository = klassRepository;
        this.leaderRepository = leaderRepository;
    }

    @PostMapping(path="/v3/klasses")
    public Klass save(@RequestBody Klass klass){
        klass.getLeader().setKlass(klass);
        return klassRepository.save(klass);
    }

    @GetMapping(path="/v3/klasses")
    public List<Klass> findAll(){
        return klassRepository.findAll();
    }
}
