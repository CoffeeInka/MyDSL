package com.gmail.pages;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.texts;
import static core.conditions.ElementConditions.text;

public class Mails {

    public static LazyCollection mailList = $$(By.cssSelector("[role=main] .zA"));

    public static void send(String mail, String subject) {
        $(byText("COMPOSE")).click();
        $(byText("Recipients")).click();
        $(By.name("to")).setValue(mail);
        $(By.name("subjectbox")).setValue(subject).pressEnter();

        $(byText("Send")).click();
    }

    public static void assertMail(int index, String text) {
        mailList.get(index).shouldHave(text(text));
    }

    public static void searchInInboxBy(String subject) {
        $(By.name("q")).setValue("in:inbox subject:" + subject).pressEnter();
    }

    public static void assertMails(String... texts) {
        mailList.shouldHave(texts(texts));
    }
}

