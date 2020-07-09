package com.example.walletshopping.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
	@Id
	private int walletId;
	private int userId;
	private int walletNumber;
	private double walletPoints;
	private LocalDate expiryDate;

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWalletNumber() {
		return walletNumber;
	}

	public void setWalletNumber(int walletNumber) {
		this.walletNumber = walletNumber;
	}

	public double getWalletPoints() {
		return walletPoints;
	}

	public void setWalletPoints(double walletPoints) {
		this.walletPoints = walletPoints;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

}
