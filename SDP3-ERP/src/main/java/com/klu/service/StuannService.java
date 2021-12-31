package com.klu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.klu.model.Announcements;

public interface StuannService {
	List<Announcements> getAllAnnouncements();
	Page<Announcements> findPaginated(int pageNo, int pageSize);
}
