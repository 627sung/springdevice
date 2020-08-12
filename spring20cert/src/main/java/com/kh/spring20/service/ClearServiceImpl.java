package com.kh.spring20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.spring20.repository.CertDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClearServiceImpl implements ClearService {

	@Autowired private CertDao certDao;
	@Override
	@Scheduled(cron="* * * * * * ")
	public void clear() {
		log.debug("clear service실행");
		certDao.claerAll();
	}

}
