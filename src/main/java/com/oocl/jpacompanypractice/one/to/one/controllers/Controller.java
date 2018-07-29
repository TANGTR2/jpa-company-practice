package com.oocl.jpacompanypractice.one.to.one.controllers;

import com.oocl.jpacompanypractice.one.to.n.entities.Company;
import com.oocl.jpacompanypractice.one.to.one.controllers.dto.KlassDTO;
import com.oocl.jpacompanypractice.one.to.one.entities.Klass;
import com.oocl.jpacompanypractice.one.to.one.entities.Leader;
import com.oocl.jpacompanypractice.one.to.one.repositories.KlassRepository;
import com.oocl.jpacompanypractice.one.to.one.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/v3/klasses/{id}")
    public KlassDTO get(@PathVariable Long id) {
        Klass klass = klassRepository.findById(id).get();
        return new KlassDTO(klass);
    }

    @PutMapping(path = "/v3/klasses/{id}")
    public KlassDTO update(@RequestBody Klass updateKlass,@PathVariable Long id) {
        Klass klass = klassRepository.findById(id).get();
        klass.setName(updateKlass.getName());
        klass.setLeader(updateKlass.getLeader());
        return new KlassDTO(klass);
    }

    @DeleteMapping(path = "/v3/klasses/{id}")
    public Klass delete(@PathVariable Long id) {
        Klass klass = klassRepository.findById(id).get();
        klassRepository.delete(klass);
        return klass;
    }

    @PostMapping(path="/v4/leaders")
    public Leader save(@RequestBody Leader leader){
        leader.getKlass().setLeader(leader);
        return leaderRepository.save(leader);
    }

    @GetMapping(path="/v4/leaders")
    public List<Leader> findAllLeaders(){
        return leaderRepository.findAll();
    }
}
