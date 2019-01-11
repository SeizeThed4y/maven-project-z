package com.WebOrdersTest;

import com.utilities.TestBase;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class amazonTest extends TestBase{

    Email email;

    @Test
    public void sendEmail123() throws EmailException {
        for (int i = 1; i < 100; i++) {
            email = new SimpleEmail();
            myLibrary.sendEmail("hahaha123hahahaha123@gmail.com",
                    "Staoggbrt73569", "TEST", "HA HA HA !!! ", "Kurshat0920@gmail.com", "juratelzat@gmail.com");
        }
    }
    }
