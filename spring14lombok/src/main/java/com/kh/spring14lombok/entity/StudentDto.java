package com.kh.spring14lombok.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StudentDto {
private String name;
private int age;
private int score;
private String when;


	
}
