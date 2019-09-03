package com.metacube.EADSession7.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.EADSession7.service.MailSender;


public class MockMailSender implements MailSender{

	@Override
	public String sendMail() {
		return "mock mail";
	}

}
