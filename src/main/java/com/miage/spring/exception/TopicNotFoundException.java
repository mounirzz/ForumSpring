package com.miage.spring.exception;

public class TopicNotFoundException extends RuntimeException {
	public TopicNotFoundException(String message) {
		super(message);
		
	}
}
