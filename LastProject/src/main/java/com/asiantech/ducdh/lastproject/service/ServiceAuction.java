package com.asiantech.ducdh.lastproject.service;

import java.util.List;

import com.asiantech.ducdh.lastproject.entity.Auction;
import com.asiantech.ducdh.lastproject.entity.Category;
import com.asiantech.ducdh.lastproject.entity.Product;
import com.asiantech.ducdh.lastproject.entity.User;

public interface ServiceAuction {

	public static String NAME_SERVICE = "auctionService";
	
	List<Auction> getListAuction();
	User checkLogin(String username, String password);
	boolean checkExits(User user);
	void addUser(User user);
	List<Category> getListCategory();
	List<Auction> getListAuction(String status, String category);
	List<Product> getListProduct();
	Category getCategory(String idCategory);
	void saveProduct(Product productNew);
	User getUser(String username);
}
