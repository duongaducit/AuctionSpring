package com.asiantech.ducdh.lastproject.repository;

import java.util.List;

import com.asiantech.ducdh.lastproject.entity.Auction;
import com.asiantech.ducdh.lastproject.entity.User;

public interface OtherRepositoryCustom {
	User checkLogin(String username,String password);
	boolean checkExits(User user);
	List<Auction> getListAuction(String status,String category);
	User getUser(String username);
}
