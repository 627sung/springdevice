package com.kh.spring20.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring20.entity.CertDto;
import com.kh.spring20.repository.CertDao;

@Service
public class CertServiceImpl implements CertService {
	@Autowired
	private CertDao certDao;
	private Random r= new Random();

	@Override
	public String generateSecret() {
		int n =r.nextInt(1000000)+0;
		Format f = new DecimalFormat("000000"); //6글자로 고정~
		String secret =f.format(n);
		return secret;
	}

	@Override
	public String generateCertification(String ip) {
		String secret = this.generateSecret();

		CertDto certDto = CertDto.builder().who(ip).secret(secret).build();
		
		certDao.insert(certDto);

		return secret;
	}

}
