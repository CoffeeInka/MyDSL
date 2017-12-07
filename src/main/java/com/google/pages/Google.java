package com.google.pages;

import core.entities.collection.LazyCollection;
import core.entities.element.LazyElement;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;

public class Google {

    public static LazyCollection results = $$(By.cssSelector(".srg>.g"));

    public static LazyElement result(int index){
        return $(By.cssSelector(".srg>.g:nth-child(" + (index+1) + ") .r>a"));
    }

    public static void search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
    }

    public static void followLink(int index) {
        result(index).click();
//        results.getWrappedEntity().get(index).$(By.cssSelector(".r>a")).click();
    }

}
