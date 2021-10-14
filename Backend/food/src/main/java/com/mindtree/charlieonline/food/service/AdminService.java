package com.mindtree.charlieonline.food.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.charlieonline.food.model.Admin;
import com.mindtree.charlieonline.food.model.ItemsList;
import com.mindtree.charlieonline.food.repository.AdminRepository;
import com.mindtree.charlieonline.food.repository.ItemsListRepository;

@Service
public class AdminService {
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ItemsListRepository itemsListRepository;

	public void addAdmin(Admin admin) {
		// String password = passwordEncoder.encode(admin.getPassword());
		// admin.setPassword(password);
		adminRepository.save(admin);
	}

	public String deleteItem(long id) {
		itemsListRepository.deleteById(id);
		return " deleted";
	}

	public ItemsList addingItem(ItemsList item) {
		return itemsListRepository.save(item);
	}

	public ItemsList updatingItem(ItemsList item, long id) {
		ItemsList item1 = itemsListRepository.getById(id);
		item1.setImage(item.getImage());
		item1.setItemname(item.getItemname());
		item1.setItemprice(item.getItemprice());
		item1.setQuantity(item.getQuantity());
		return itemsListRepository.save(item1);
	}

	public boolean checkingCredentials(Admin admin) {
		String user = admin.getEmailId();
		// String password=passwordEncoder.encode(admin.getPassword());
		String password = admin.getPassword();
		Admin admin1 = adminRepository.findByEmailId(user);
		if(admin1==null) {
			return false;
		}

		if (user.equals(admin1.getEmailId()) && password.equals(admin1.getPassword())) {
			return true;
		}
		return false;
	}
}