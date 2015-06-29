package com.asiantech.ducdh.lastproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@NotNull
	@Column(name = "id_category")
	@GeneratedValue
	private int idCategory;
	
	@NotNull
	@Column(name = "name_category")
	private String nameCategory;
	
	@Column(name = "description_category")
	private String descriptionCategory;

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescriptionCategory() {
		return descriptionCategory;
	}

	public void setDescriptionCategory(String descriptionCtg) {
		this.descriptionCategory = descriptionCtg;
	}

	public Category(int idCategory, String nameCategory,
			String descriptionCtg) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCtg;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
