package com.SanketIT.Blog_App.excepation;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMapper {
	
	public ResponseEntity<ExcepationMessage> dataNotFound(ResourcesNotFoundExcepation e){
		
		ExcepationMessage msg=new ExcepationMessage();
		
		msg.setErrorCode("BAA0001");
		msg.setMsg(e.getMessage());
		msg.setLocalDate(LocalDate.now());
		
		return new ResponseEntity<ExcepationMessage>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

}
