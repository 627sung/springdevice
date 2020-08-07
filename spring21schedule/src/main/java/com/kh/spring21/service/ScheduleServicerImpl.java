package com.kh.spring21.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ScheduleServicerImpl implements ScheduleService{

	@Override
	//@Scheduled(initialDelay = 1000 , fixedDelay = 1000)
	//@Scheduled(cron="* * * * * *")//매초마다
	//@Scheduled(cron="*/2 * * * * *")//매 2초마다
	//@Scheduled(cron="10-20 * * * * *")//매 10초~20초 사이만
	//@Scheduled(cron= "0 * * * * *")//매분 0초마다
	//@Scheduled(cron= "0 0 * * * *")//매시 정각마다
	//@Scheduled(cron= "0 0 0 * * *")//매시 자정마다
	//@Scheduled(cron= "0 0 6 * * *")//매일 아침 6시마다
	//@Scheduled(cron= "0 0 7 1 * *")//매월 1일 아침 7시마다
	@Scheduled(cron="* * * ? * fri")//매월 금요일 매초마다
	public void oneSecond() {
		log.debug("스케쥴러의 테스트");
	}
	
	
	
}
