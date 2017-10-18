package com.google.conditions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Condition {

    public abstract WebElement apply(By locator);
}
