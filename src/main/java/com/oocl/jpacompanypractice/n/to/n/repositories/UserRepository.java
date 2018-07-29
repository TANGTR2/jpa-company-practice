package com.oocl.jpacompanypractice.n.to.n.repositories;

import com.oocl.jpacompanypractice.n.to.n.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
