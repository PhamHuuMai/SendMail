package vn.com.ntqsolution;

import vn.com.ntqsolution.worker.email.EmailDeliver;

public class UserManagementApplication{
    
    public static void main(String[] args) {  	
        new EmailDeliver().deliver();
    }
}