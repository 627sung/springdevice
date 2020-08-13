package com.kh.spring26.pay;

import java.security.PrivateKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KakaoPayCancleVO {
	private String aid, tid, cid, status;
	   private String partner_order_id, partner_user_id;
	   private String partner_method_type;
	   
	   private KakaoPayFinishAmountVO amount;
	   private KakaoPayFinishAmountVO approved_cancel_amount;
	   private KakaoPayFinishAmountVO canceled_amount;
	   private KakaoPayFinishAmountVO cancel_available_amount;
	   
	   private String item_name;
	   private String item_code;
	   private String quantity;
	   private String created_at, approved_at, canceled_at;
	   private String payload;
	   





}
