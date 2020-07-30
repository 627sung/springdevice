package com.kh.practice.repository;

import java.util.List;


import com.kh.practice.entity.ItemDto;
public interface ItemDao {

void insert(ItemDto itemDto);

List<ItemDto> getlist();



}
