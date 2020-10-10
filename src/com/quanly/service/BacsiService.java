package com.quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanly.entity.Bacsi;
import com.quanly.repository.BacsiRepository;



@Service
@Transactional
public class BacsiService {
	@Autowired BacsiRepository repo;
	
	public void save(Bacsi bacsi) {
		repo.save(bacsi);
	}
	
	public List<Bacsi> listAll() {
		return (List<Bacsi>) repo.findAll();
	}
	
	public Bacsi get(String id) {
		return repo.findById(id).get();
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	

}
