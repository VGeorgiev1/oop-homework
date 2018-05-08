package org.elsys.cardgame.api;

public class CardException extends RuntimeException {

	/**
	 * 
	 */
	private String errorMsg;
	public CardException(String err){
		this.errorMsg = err;
	}
	public String getErrorMsg() {
		return this.errorMsg;
	}
	
	private static final long serialVersionUID = 8822513014262189134L;

}