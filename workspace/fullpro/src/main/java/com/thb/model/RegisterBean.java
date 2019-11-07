package com.thb.model;

public class RegisterBean {
        private String fullname;
        private String emailId;
        private String category;
        private String gender;
        private String Password;
        private String urlData;
      
        public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getEmailId() {
			return emailId;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		
		public String getUrlData() {
            return urlData;
    }
    public void setUrlData(String urlData) {
            this.urlData = urlData;
    }
		
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		

}

