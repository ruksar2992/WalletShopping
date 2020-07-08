package com.example.walletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Wallet;
@Repository
public interface WalletDao extends CrudRepository<Wallet, Integer> {

	Wallet findAllByWalletId(int walletId);

}
