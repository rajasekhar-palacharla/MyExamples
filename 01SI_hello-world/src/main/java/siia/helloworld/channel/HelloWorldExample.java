/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package siia.helloworld.channel;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 * @author Mark Fisher
 */
public class HelloWorldExample {

  public static void main(String args[]) {
	String cfg = "siia/helloworld/channel/context.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(cfg);
    MessageChannel channel = context.getBean("names", MessageChannel.class);
    Message<String> message = MessageBuilder.withPayload("World").build();
    channel.send(message);
    channel.send(message);
    channel.send(message);
    channel.send(message);
  }
}
