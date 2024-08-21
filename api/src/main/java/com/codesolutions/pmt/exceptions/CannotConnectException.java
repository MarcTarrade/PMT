package com.codesolutions.pmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason = "Mauvais email ou mot de passe")
public class CannotConnectException extends RuntimeException {
	
}

