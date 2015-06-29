package com.asiantech.ducdh.lastproject.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.asiantech.ducdh.lastproject.entity.Auction;
import com.asiantech.ducdh.lastproject.entity.User;

public class OtherRepositoryImpl implements OtherRepositoryCustom {

	@PersistenceContext
	EntityManager entity;

	@Override
	public User checkLogin(String username, String password) {
		boolean check = false;
		User result = null;
		List<User> list = entity.createQuery("select u from User u")
				.getResultList();
		for (User user : list) {
			if (username.equals(user.getUsername())
					&& (password.equals(user.getPassword()))) {
				result = user;
			}
		}
		return result;
	}

	@Override
	public boolean checkExits(User user) {
		boolean check = false;
		List<User> list = entity.createQuery("select u from User u")
				.getResultList();
		for (User userSQL : list) {
			if (user.getUsername().equals(userSQL.getUsername())) {
				check = true;
			}
		}

		return check;
	}

	@Override
	public List<Auction> getListAuction(String status, String category) {
		// TODO Auto-generated method stub
		List<Auction> list = entity.createQuery("select a from Auction a").getResultList();
		List<Auction> listResult = new ArrayList<Auction>();
		for (Auction auction : list){
			if ((status.equals(auction.getProduct().getStatusProduct()))&&(category.equals(auction.getProduct().getCategory().getNameCategory()))){
				listResult.add(auction);
			}
		}
		
		return listResult;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		List<User> list = entity.createQuery("select u from User u")
				.getResultList();
		for (User userSQL : list) {
			if (username.equals(userSQL.getUsername())) {
				return userSQL;
			}
		}
		
		return null;
	}
}
