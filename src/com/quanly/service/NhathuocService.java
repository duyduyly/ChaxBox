package com.quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanly.entity.Nhathuoc;
import com.quanly.repository.NhathuocRepository;

@Service
@Transactional
public class NhathuocService {

	@Autowired
	NhathuocRepository repo;

	public void save(Nhathuoc Nhathuoc) {
		repo.save(Nhathuoc);
	}

	public List<Nhathuoc> listAll() {
		return (List<Nhathuoc>) repo.findAll();
	}

	public Nhathuoc get(String id) {
		return repo.findById(id).get();
	}

	public void delete(String id) {
		repo.deleteById(id);
	}
}
