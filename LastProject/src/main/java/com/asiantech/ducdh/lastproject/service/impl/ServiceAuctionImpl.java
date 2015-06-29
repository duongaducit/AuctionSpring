package com.asiantech.ducdh.lastproject.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.asiantech.ducdh.lastproject.entity.Auction;
import com.asiantech.ducdh.lastproject.entity.Category;
import com.asiantech.ducdh.lastproject.entity.Product;
import com.asiantech.ducdh.lastproject.entity.User;
import com.asiantech.ducdh.lastproject.repository.AuctionsRepository;
import com.asiantech.ducdh.lastproject.repository.CategoryRepository;
import com.asiantech.ducdh.lastproject.repository.OtherRepository;
import com.asiantech.ducdh.lastproject.repository.ProductRepository;
import com.asiantech.ducdh.lastproject.repository.UserRepository;
import com.asiantech.ducdh.lastproject.service.ServiceAuction;

@Service(ServiceAuction.NAME_SERVICE)
public class ServiceAuctionImpl implements ServiceAuction{
	
	@Resource
	UserRepository userRepository;
	@Resource
	ProductRepository productRepository;
	@Resource
	AuctionsRepository auctionRepository;
	@Resource
	OtherRepository otherRepository;
	@Resource
	CategoryRepository categoryRepository;
	
	@Override
	public List<Auction> getListAuction() {
		
		return auctionRepository.findAll();
	}
	
	public User checkLogin(String username, String password){
		return otherRepository.checkLogin(username, password);
	}

	@Override
	public boolean checkExits(User user) {
		// TODO Auto-generated method stub
		return otherRepository.checkExits(user);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<Auction> getListAuction(String status, String category) {
		// TODO Auto-generated method stub
		return otherRepository.getListAuction(status,category);
	}

	@Override
	public List<Product> getListProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Category getCategory(String idCategory) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(Integer.parseInt(idCategory));
	}

	@Override
	public void saveProduct(Product productNew) {
		// TODO Auto-generated method stub
		productRepository.save(productNew);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return otherRepository.getUser(username);
	}
}
