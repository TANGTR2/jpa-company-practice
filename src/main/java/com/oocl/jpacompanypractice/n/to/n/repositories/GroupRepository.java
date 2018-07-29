package com.oocl.jpacompanypractice.n.to.n.repositories;

import com.oocl.jpacompanypractice.n.to.n.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
