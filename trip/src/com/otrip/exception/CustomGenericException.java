package com.otrip.exception;

/**
 * @see 自定义运行异常 
 * @author zhongJc
 *
 */
public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = -6439554857155922194L;

	private String errCode;
    private String errMsg;
    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public CustomGenericException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}

