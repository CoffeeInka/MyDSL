package com.gmail.pages;

import org.openqa.selenium.By;

import static core.ConciseAPI.$;
import static core.ConciseAPI.open;


public class Gmail {

    public static void visit() {
        open("http://gmail.com/");
    }

    public static void login(String mail, String password) {
        $(By.id("identifierId")).setValue(mail).pressEnter();
        $(By.name("password")).setValue(password).pressEnter();
    }

}
