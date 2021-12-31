package com.klu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.klu.model.Announcements;

public interface AnnouncementsService {
	List<Announcements> getAllAnnouncements();
	void saveAnnouncements(Announcements ann);
	Announcements getAnnouncementsById(long id);
	void deleteAnnouncementsById(long id);
	Page<Announcements> findPaginated(int pageNo, int pageSize);
}
