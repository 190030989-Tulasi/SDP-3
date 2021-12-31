package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klu.model.Announcements;
import com.klu.repository.AnnouncementsRepository;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService{
	@Autowired
    private AnnouncementsRepository announcementsRepository;

    @Override
    public List < Announcements > getAllAnnouncements() {
        return announcementsRepository.findAll();
    }
    
    @Override
    public void saveAnnouncements(Announcements ann) {
        this.announcementsRepository.save(ann);
    }
    
    @Override
    public Announcements getAnnouncementsById(long id) {
        Optional < Announcements > optional = announcementsRepository.findById(id);
        Announcements employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Announcements not found for id :: " + id);
        }
        return employee;
    }
    
    @Override
    public void deleteAnnouncementsById(long id) {
     this.announcementsRepository.deleteById(id);
    }
    
    @Override
    public Page<Announcements> findPaginated(int pageNo, int pageSize) {
     Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
     return this.announcementsRepository.findAll(pageable);
    }
}
