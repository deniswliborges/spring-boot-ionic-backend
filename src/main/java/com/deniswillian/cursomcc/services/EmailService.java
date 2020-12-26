package com.deniswillian.cursomcc.services;

import org.springframework.mail.SimpleMailMessage;

import com.deniswillian.cursomcc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
