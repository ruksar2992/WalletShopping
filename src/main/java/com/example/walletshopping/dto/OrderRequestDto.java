package com.example.walletshopping.dto;

import java.util.List;

public class OrderRequestDto {
	private List<Integer> cartIdLists;
	private int walletId;
	
	public List<Integer> getCartIdLists() {
		return cartIdLists;
	}
	public void setCartIdLists(List<Integer> cartIdLists) {
		this.cartIdLists = cartIdLists;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	



}
