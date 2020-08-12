package com.kh.spring25.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class StudentDto {

	private String name;
	private int score;
	private int age;
	private String when;


}
