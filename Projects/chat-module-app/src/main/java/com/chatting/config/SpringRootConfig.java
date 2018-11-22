package com.chatting.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.chatting.services" })
public class SpringRootConfig {
}
