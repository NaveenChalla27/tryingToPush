package com.mindtree.charlieonline.food.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Admin {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String firstName;
		private String lastName;
		private String emailId;
		private String phonenumber;
		private String address;
		private String password;

		public Admin() {
			super();
		}

		public Admin(String firstname, String lastname, String emailid, String phonenumber, String address,
				String password) {
			super();

			this.firstName = firstname;
			this.lastName = lastname;
			this.password = password;
			this.emailId = emailid;
			this.phonenumber = phonenumber;
			this.address = address;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public long getId() {
			return id;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
}
