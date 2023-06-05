package com.plurasight.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plurasight.conferencedemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
    
}
