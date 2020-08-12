package com.kh.spring22.service;

import com.kh.spring22.entity.CategoryDto;
import com.kh.spring22.entity.ProductDto;

public interface MarketService {
 void add(CategoryDto categoryDto, ProductDto productDto);
}
