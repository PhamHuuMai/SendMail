package com.mycompany.sendmail;

public class Main {

    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        (new EmailDeliver()).deliver();
        System.out.println("-----------------------------------------");
    }
}
