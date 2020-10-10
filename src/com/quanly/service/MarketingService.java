package com.quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanly.entity.Marketing;
import com.quanly.repository.MarketingRepository;

@Service
@Transactional
public class MarketingService {
	@Autowired MarketingRepository repo;
	
	public List<Marketing> listAll() {
		return (List<Marketing>) repo.findAll();
	}
	
	public Marketing get(String id) {
		return repo.findById(id).get();
	}
	public void save(Marketing marketing) {
		repo.save(marketing);
	}
	
	
}
