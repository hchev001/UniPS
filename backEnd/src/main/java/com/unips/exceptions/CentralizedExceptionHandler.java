package com.unips.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.unips.response.Response;

@ControllerAdvice
public class CentralizedExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public <AnyData> Response<AnyData> error(Exception e) {
		log.error(e.getMessage());
		return Response.failure(e.getMessage());
	}

}
