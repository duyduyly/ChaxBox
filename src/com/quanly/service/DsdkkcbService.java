package com.quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanly.entity.Dsdkkcb;
import com.quanly.repository.DsdkkcbRepository;

@Service
@Transactional

public class DsdkkcbService {
	@Autowired
	DsdkkcbRepository repo;

	public void save(Dsdkkcb dsdkkcb) {
		repo.save(dsdkkcb);
	}

	public List<Dsdkkcb> listAll() {
		return (List<Dsdkkcb>) repo.findAll();
	}

	public Dsdkkcb get(String id) {
		return repo.findById(id).get();
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

}
