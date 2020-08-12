package com.kh.spring24.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//사용자에게 보낼 메세저의 원형 
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MessageVO {
 private String id;
 private String payload;
	
	
}
