package in.cdac.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//@RestController
public class CustomizedResponseEntityExceptionHandling extends ResponseEntityExceptionHandler {

	
	//uncomment for Handling exception on all controllers from one place
	
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		System.out.println(" anuja exception");
			ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), new Date(),
					request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.I_AM_A_TEAPOT);
		
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println(" anuja exception");
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), new Date(),
																				ex.getBindingResult().toString());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
*/
}
