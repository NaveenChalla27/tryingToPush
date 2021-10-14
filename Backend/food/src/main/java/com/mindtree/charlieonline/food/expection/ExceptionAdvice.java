package com.mindtree.charlieonline.food.expection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
