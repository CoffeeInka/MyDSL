package com.google.pages;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.By;

import static core.ConciseAPI.$;
import static core.ConciseAPI.$$;

public class Google {

    public static LazyCollection results = $$(By.cssSelector(".srg>.g"));

    public static void search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
    }

    public static void followLink(int index) {
        results.get(index).$(".r>a").click();
    }

}
