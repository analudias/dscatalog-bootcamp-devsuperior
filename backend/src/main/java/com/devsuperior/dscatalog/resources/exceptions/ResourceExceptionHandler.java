package com.devsuperior.dscatalog.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dscatalog.services.exception.EntityNotFoundException;

@ControllerAdvice //permite que essa classe intercepte alguma exceção que aconteça na camada de Controlador REST
public class ResourceExceptionHandler {
	
	//este método vai ser uma resposta de requisição onde o payload dessa resposta vai ser um objeto do tipo StandardErros
	//para podermos reproduzir a estrutura do erro do Postman, que será padronizada
	//sempre que acontecer alguma exceção desse tipo nos controladores REST, o tratamento dela será feito por este médoto
	@ExceptionHandler(EntityNotFoundException.class) //para saber que tipo de exceção ele vai interceptar
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value()); //.value para converter do tipo enumerado para inteiro
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
