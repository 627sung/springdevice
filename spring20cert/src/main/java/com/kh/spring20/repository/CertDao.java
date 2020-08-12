package com.kh.spring20.repository;

import org.springframework.stereotype.Repository;

import com.kh.spring20.entity.CertDto;

public interface CertDao {
 void insert(CertDto certDto);
 boolean validate(CertDto certDto);
 void claerAll();
 
 
}
