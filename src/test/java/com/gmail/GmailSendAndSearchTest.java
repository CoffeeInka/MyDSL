package com.gmail;


import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import com.gmail.pages.Menu;
import com.gmail.testdata.TestData;
import com.testconfigs.BaseTest;
import core.Configuration;
import core.Helpers;
import org.junit.Test;

public class GmailSendAndSearchTest extends BaseTest {

    {
        Configuration.timeout = 25000;
    }

    @Test
    public void gmailSendAndSearch() {

        Gmail.visit();
        Gmail.login(TestData.mail, TestData.password);

        String subject = Helpers.getUniqueString("Test");
        Mails.send(TestData.mail, subject);

        Menu.refresh();

        Mails.assertMail(0, subject);

        Menu.goToSent();
        Mails.assertMail(0, subject);

        Mails.searchInInboxBy(subject);
        Mails.assertMails(subject);
    }


}