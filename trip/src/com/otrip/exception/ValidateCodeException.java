package com.otrip.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @see 抛出验证码出错异常
 * @author Administrator
 *
 */
public class ValidateCodeException extends AuthenticationException {

	public ValidateCodeException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8542371584087062734L;

}
