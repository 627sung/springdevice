package com.kh.spring26.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KakaoPayFinishVO {
private String aid,tid,cid,sid;
private String partner_order_id,partner_user_id;
private String payment_method_type;


private String item_name,item_code;
private int quantity;
private String created_at;
private String approved_at;

private KakaoPayFinishAmountVO amount;
private KakaoPayFinishCardinfoVO card_info;

	
}
