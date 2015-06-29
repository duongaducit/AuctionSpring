package com.asiantech.ducdh.lastproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.asiantech.ducdh.lastproject.entity.Auction;
import com.asiantech.ducdh.lastproject.entity.Category;
import com.asiantech.ducdh.lastproject.entity.Product;
import com.asiantech.ducdh.lastproject.entity.User;
import com.asiantech.ducdh.lastproject.service.ServiceAuction;

@Controller
public class UserController {

	@Autowired
	@Qualifier(ServiceAuction.NAME_SERVICE)
	private ServiceAuction service;

	static String STATUS = "aution";
	static int CATEGORY = 0;

	@RequestMapping("/user/{username}/newProduct")
	public ModelAndView newProduct(ModelAndView model,
			@PathVariable("username") String username) throws IOException {

		List<Category> listCategory = service.getListCategory();
		model.addObject("listCategory", listCategory);
		User user = service.getUser(username);
		model.addObject("user", user);
		model.setViewName("/user/newAuction");

		return model;
	}

	@RequestMapping("/user/{username}/saveProduct")
	public String saveProduct(
			@RequestParam(required = false) MultipartFile file,
			ModelAndView model, HttpServletRequest request,
			@PathVariable("username") String username) throws IOException {

		String nameProduct = request.getParameter("nameProduct");
		String idCategory = request.getParameter("category");
		String despProduct = request.getParameter("description");
		String timeBegin = request.getParameter("timeBegin");
		String timeEnd = request.getParameter("timeEnd");
		String minBid = request.getParameter("minFee");
		String incBid = request.getParameter("incFee");
		String pathImg = UploadFileToDisc(file);
		User user = service.getUser(username);
		Category category = service.getCategory(idCategory);
		Product productNew = new Product(nameProduct, category, user,
				despProduct, pathImg, "WAIT", timeBegin, timeEnd,
				Integer.parseInt(incBid), Integer.parseInt(minBid));
		service.saveProduct(productNew);
		// get user
		// get category
		model.addObject("user", user);
		model.addObject("listProduct", service.getListProduct());

		return "redirect:/user/" + user.getUsername() + "/"
				+ productNew.getIdProduct();
	}

	@RequestMapping("/user/{username}/all")
	public ModelAndView userAll(ModelAndView model,
			@PathVariable("username") String username) throws IOException {

		model.setViewName("/user/managerAuction");

		return model;
	}

	@RequestMapping("/user/{username}/auction")
	public String userAuction(ModelAndView model,
			@PathVariable("username") String username) throws IOException {

		STATUS = "aution";
		return "redirect:/" + username + "/managerAuction";
	}

	@RequestMapping("/user/{username}/juststop")
	public String userJustStop(ModelAndView model,
			@PathVariable("username") String username) throws IOException {

		STATUS = "juststop";
		return "redirect:/" + username + "/managerAuction";
	}

	@RequestMapping("/user/{username}/wait")
	public String userWait(ModelAndView model,
			@PathVariable("username") String username) throws IOException {

		STATUS = "wait";
		return "redirect:/" + username + "/managerAuction";
	}

	@RequestMapping("/user/{username}/{prdid}")
	public ModelAndView userWait(ModelAndView model,
			@PathVariable("username") String username,
			@PathVariable("prdid") String id) throws IOException {

		User user = service.getUser(username);
		model.addObject("user", user);
		model.addObject("id", id);
		model.setViewName("/user/selectProduct");

		return model;
	}

	public String UploadFileToDisc(MultipartFile file) {
		String name = "";
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				name = "/home/aduc/" + file.getOriginalFilename();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name)));
				stream.write(bytes);
				stream.close();
				return file.getOriginalFilename();

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			System.out.println("loi");
			return null;

		}
	}

	@RequestMapping("{username}/managerUser")
	public ModelAndView manageUser(ModelAndView model,
			@PathVariable("username") String username,
			HttpServletRequest request) throws IOException {
		User user = service.getUser(username);
		model.addObject("user", user);
		model.setViewName("/user/managerUser");
		return model;
	}

	@RequestMapping("/{username}/managerAuction")
	public ModelAndView manageAuction(ModelAndView model,
			@PathVariable("username") String username,
			HttpServletRequest request) throws IOException {

		List<Category> listCategory = service.getListCategory();
		List<Auction> listAuction = service.getListAuction();
		List<Product> listProduct = service.getListProduct();
		User user = service.getUser(username);
		model.addObject("status", STATUS);
		model.addObject("user", user);
		model.addObject("listCateogry", listCategory);
		model.addObject("listAuction", listAuction);
		model.addObject("listProduct", listProduct);
		model.setViewName("/user/managerAuction");

		return model;
	}

	@RequestMapping("/{username}/managerNotify")
	public ModelAndView manageNotify(ModelAndView model,
			@PathVariable("username") String username,
			HttpServletRequest request) throws IOException {

		User user = service.getUser(username);
		model.addObject("user", user);
		model.addObject("time", "July 23, 2015 18:25:00");
		model.setViewName("managerNotify");

		return model;
	}

	@RequestMapping("/{username}/edit")
	public ModelAndView userEdit(ModelAndView model,
			@PathVariable("username") String username,
			HttpServletRequest request) throws IOException {

		User user = service.getUser(username);
		model.addObject("user", user);
		model.setViewName("/user/editUser");

		return model;
	}

	@RequestMapping(value = "/{username}/save", method = RequestMethod.POST)
	public String saveTask(@PathVariable("username") String username,
			@RequestParam(required = false) MultipartFile file, Model model,
			@ModelAttribute("user") User user,HttpServletRequest request) {
		if (!file.isEmpty()) {
			user.setPathImg(UploadFileToDisc(file));
		}
		service.addUser(user);
		request.getSession().setAttribute("user", user);
		return "redirect:/" + user.getUsername() + "/managerUser";
	}

}
