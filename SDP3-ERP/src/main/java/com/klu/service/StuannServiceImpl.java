package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klu.model.Announcements;
import com.klu.repository.StuannRepository;
@Service
public class StuannServiceImpl implements StuannService{
	@Autowired
    private StuannRepository announcementsRepository;

    @Override
    public List < Announcements > getAllAnnouncements() {
        return announcementsRepository.findAll();
    }
    @Override
    public Page<Announcements> findPaginated(int pageNo, int pageSize) {
     Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
     return this.announcementsRepository.findAll(pageable);
    }
    
}
