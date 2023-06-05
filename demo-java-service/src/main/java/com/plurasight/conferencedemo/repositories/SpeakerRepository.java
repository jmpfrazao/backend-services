package com.plurasight.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plurasight.conferencedemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    
}