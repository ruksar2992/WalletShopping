package com.example.walletshopping.service;

import com.example.walletshopping.dto.OrderHistoryListDto;



public interface OrderHistoryService {

 

    OrderHistoryListDto getOrderHistory(int userId);

 

    OrderHistoryListDto getOrderHistoryByMonth(int userId, int month);

 

 

}
