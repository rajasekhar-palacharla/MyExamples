package com.mysample;

import org.springframework.integration.MessageHeaders;
import org.springframework.integration.message.GenericMessage;

public class StringMessage extends GenericMessage<String> {

	private static final long serialVersionUID = 1L;

	@Override
	public MessageHeaders getHeaders() {
		return super.getHeaders();
	}

	public StringMessage(String payload) {
		super(payload);
	}
}
