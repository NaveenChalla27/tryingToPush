package com.mindtree.charlieonline.food.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customer;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval=true)
	private List<MenuItem> menu = new ArrayList<MenuItem>();

	public Cart() {
		super();
	}

	public Cart(Date date) {
		super();
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<MenuItem> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuItem> menu) {
		this.menu = menu;
		for (MenuItem menuitem : menu) {
			menuitem.setCart(this);
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
