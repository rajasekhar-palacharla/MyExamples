package com.mysample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;

public class BootStrap {

	public static void main(String[] args) {

		// load the spring configuration
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/mysample/contexts.xml");

		// get an instance of the input channel from the context
		final MessageChannel input = (MessageChannel) context.getBean("input");

		// The below thread runs a loop and sends 15 messages to input channel
		// with different values for the testHeader depending on certain logic
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				if (input != null) {
					for (int i = 0; i < 15; i++) {
						Map<String, Object> headers = null;
						if (i % 7 == 0 || i % 5 == 0) {
							// if i is divisible by 7 set the testHeader value
							// for the message to shouter so that the router
							// sends it to the shouterOutput channel
							if (i % 7 == 0) {
								headers = new HashMap<String, Object>();
								headers.put("testHeader", "shouter");
								Message<?> m = new GenericMessage<String>(
										"Spring Integration rocks ----- " + i,
										headers);
								input.send(m);
							}
							// if i is divisible by 5 set the testHeader value
							// for the message to messenger so that the router
							// sends it to the messengerOutput channel
							if (i % 5 == 0) {
								headers = new HashMap<String, Object>();
								headers.put("testHeader", "messenger");
								Message<?> m = new GenericMessage<String>(
										"Spring Integration rocks ----- " + i,
										headers);
								input.send(m);
							}
						}
						// in rest all cases set the testHeader value for the
						// message to default so that the router sends it to the
						// defaultOutput channel
						else {
							headers = new HashMap<String, Object>();
							headers.put("testHeader", "default");
							Message<?> m = new GenericMessage<String>(
									"Spring Integration rocks ----- " + i,
									headers);
							input.send(m);
						}
					}
				}
			}
		});

		t.start();

		// get an instance of the shouterOutput channel
		final PollableChannel shouterOutput = (PollableChannel) context
				.getBean("shouterOutput");

		// The below thread runs till there is any message in the output channel
		// 'shouterOutput'
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Message<?> reply = null;
				if (shouterOutput != null) {
					do {
						// read the shouterOutput channel for a message
						reply = shouterOutput.receive();
						System.out.println("shouter received: " + reply);
					} while (reply != null);
				}
			}
		});

		t1.start();

		final PollableChannel messengerOutput = (PollableChannel) context
				.getBean("messengerOutput");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Message<?> reply = null;
				if (messengerOutput != null) {
					do {
						// read the messengerOutput channel for a message
						reply = messengerOutput.receive();
						System.out.println("messenger received: " + reply);
					} while (reply != null);
				}
			}
		});
		t2.start();

		final PollableChannel defaultOutput = (PollableChannel) context
				.getBean("defaultOutput");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				Message<?> reply = null;
				if (defaultOutput != null) {
					do {
						// read the defaultOutput channel for a message
						reply = defaultOutput.receive();
						System.out.println("default received: " + reply);
					} while (reply != null);
				}

			}
		});
		t3.start();
	}
}
