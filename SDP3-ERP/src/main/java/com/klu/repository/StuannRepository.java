package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.model.Announcements;

public interface StuannRepository extends JpaRepository<Announcements, Long>{

}
