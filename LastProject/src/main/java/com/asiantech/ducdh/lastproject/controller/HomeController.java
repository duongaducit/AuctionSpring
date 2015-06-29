package com.asiantech.ducdh.lastproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asiantech.ducdh.lastproject.entity.Auction;
import com.asiantech.ducdh.lastproject.entity.Category;
import com.asiantech.ducdh.lastproject.entity.Product;
import com.asiantech.ducdh.lastproject.entity.User;
import com.asiantech.ducdh.lastproject.service.ServiceAuction;

@Controller
public class HomeController {
	@Autowired
	@Qualifier(ServiceAuction.NAME_SERVICE)
	private ServiceAuction service;
	
	static String STATUS = "aution";
	static int CATEGORY = 0;

	@RequestMapping("/")
	public ModelAndView home(ModelAndView model, HttpServletRequest request)
			throws IOException {
		List<Category> listCategory = service.getListCategory();
		List<Auction> listAuction = service.getListAuction();
		List<Product> listProduct = service.getListProduct();
		User username = (User) request.getSession().getAttribute("user");
		model.addObject("status", STATUS);
		model.addObject("listCateogry", listCategory);
		model.addObject("listAuction", listAuction);
		model.addObject("listProduct", listProduct);
		if (username == null) {
			model.setViewName("home");
		} else {
			model.setViewName("/user/home");
			model.addObject("user", username);
		}

		return model;
	}

	@RequestMapping("/login")
	public ModelAndView login(ModelAndView model) throws IOException {

		model.setViewName("login");

		return model;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
			throws IOException {

		request.getSession().invalidate();

		return "redirect:/";
	}

	@RequestMapping("/signup")
	public ModelAndView signup(ModelAndView model) throws IOException {

		model.setViewName("signup");

		return model;
	}

	@RequestMapping("/loginSystem")
	public String loginSystem(ModelAndView model,
			HttpServletRequest request) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User userLogin = service.checkLogin(username, password);

		if (userLogin != null) {
			if (userLogin.getRoleUser().equals("ROLE_ADMIN")) {
				model.addObject("user", userLogin);
				request.getSession().setAttribute("user", userLogin);
				return "admin/home";
			} else {
				request.getSession().setAttribute("user", userLogin);
				
				return "redirect:/";
			}
		} else {
			return "login";
		}
	}

	@RequestMapping("/saveAccount")
	public String saveAccount(ModelAndView model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = "Additional";
		User user = new User(username, password, email, address);
		if (!service.checkExits(user)) {
			service.addUser(user);
			request.getSession().setAttribute("user", user);
			return "redirect:/";
		} else {
			return "signup";
		}
	}

	@RequestMapping("/auction")
	public String selectAuction(ModelAndView model,
			HttpServletRequest request) throws IOException {
		STATUS = "aution";
		return "redirect:/";
	}

	@RequestMapping("/detailProduct")
	public ModelAndView detailProduct(ModelAndView model) throws IOException {

		model.setViewName("detailProduct");

		return model;
	}

	@RequestMapping("/detailUser")
	public ModelAndView detailUser(ModelAndView model) throws IOException {

		model.setViewName("detailUser");

		return model;
	}

	@RequestMapping("/juststop")
	public String selectStop(ModelAndView model,
			HttpServletRequest request) throws IOException {
		STATUS = "juststop";
		return "redirect:/";
	}

	@RequestMapping("/wait")
	public String selectWait(ModelAndView model,
			HttpServletRequest request) throws IOException {
		STATUS = "wait";
		return "redirect:/";
	}

	@RequestMapping("/{status}/{idCategory}")
	public String viewLap(ModelAndView model,
			@PathVariable("status") String status, @PathVariable("idCategory") String idCategory, HttpServletRequest request)
			throws IOException {

		STATUS = status;
		CATEGORY = Integer.parseInt(idCategory);
		return "redirect:/";
	}

}
