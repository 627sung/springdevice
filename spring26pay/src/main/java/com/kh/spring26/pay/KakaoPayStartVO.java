package com.kh.spring26.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KakaoPayStartVO {
	String partner_order_id;
	String partner_user_id;
	String item_name;
	int quantity;
	int total_amount;

}
