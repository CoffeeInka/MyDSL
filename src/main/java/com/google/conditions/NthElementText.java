package com.google.conditions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.google.core.DSL.getDriver;

public class NthElementText extends Condition {


    private String text;
    private int index;
    private List<String> actualTexts;

    public NthElementText(int i, String t){
        text = t;
        index = i;
    }

    @Override
    public WebElement apply(By elementsListLocator) {
        List<WebElement> elementsList = getDriver().findElements(elementsListLocator);
        actualTexts = new ArrayList<>();
        for (WebElement element : elementsList) {
            if (element.isDisplayed()){
                actualTexts.add(element.getText());}
        }
        for (int i = 0; i < actualTexts.size(); i++) {
            if (actualTexts.get(i).equals(text)) {
                return elementsList.get(i);
            }
        }
        return null;
    }
}
