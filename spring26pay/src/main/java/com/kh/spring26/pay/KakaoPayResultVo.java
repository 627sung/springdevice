package com.kh.spring26.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 이 클래스는 결제요청의 응답이 저장될 클래스 

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class KakaoPayResultVo {

	
private String tid;
private String next_redirect_pc_url;	
private String created_at;	
}
