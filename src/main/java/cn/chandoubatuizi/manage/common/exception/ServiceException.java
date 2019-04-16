package cn.chandoubatuizi.manage.common.exception;

/**
 * 自定义异常
 */
public class ServiceException extends Exception {

    private int errorCode;

    private String errorMessage;

    public ServiceException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ServiceException() {
        super();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
