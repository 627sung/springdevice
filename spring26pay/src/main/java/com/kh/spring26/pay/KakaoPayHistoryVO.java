package com.kh.spring26.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class KakaoPayHistoryVO {

	private String tid;
	private String cid;
	private String status;
	private String partner_order_id;
	private String payment_method_type;
	private String item_name;
	private String item_code;
	private String quantity;

	private KakaoPayFinishAmountVO amount;
	private KakaoPayFinishAmountVO canceled_amount;
	private KakaoPayFinishAmountVO cancel_available_amount;


	
	
}
