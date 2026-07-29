package com.ktdsuniversity.edu.oop.exceptions;

/**
 * GoodsHolder 의 생성자에 잘못된 값을 전달했을 때 발생하는 예외다.
 */
public class HolderInitiateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766163612547661107L;
	
	public HolderInitiateException(String message) {
		super(message);
	}
}
