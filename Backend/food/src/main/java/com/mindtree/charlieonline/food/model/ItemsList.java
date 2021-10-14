package com.mindtree.charlieonline.food.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String Itemname;
	private double Itemprice;
	private String quantity;
	private String image;

	public ItemsList() {
		super();
	}

	public ItemsList(String itemname, double itemprice, String quantity, String image) {
		super();
		Itemname = itemname;
		Itemprice = itemprice;
		this.quantity = quantity;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemname() {
		return Itemname;
	}

	public void setItemname(String itemname) {
		Itemname = itemname;
	}

	public double getItemprice() {
		return Itemprice;
	}

	public void setItemprice(double itemprice) {
		Itemprice = itemprice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
