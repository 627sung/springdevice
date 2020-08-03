package com.kh.spring14lombok.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class MenuDto {

	@Setter @Getter
	private String name;

	@Setter @Getter
	private int price;

}
