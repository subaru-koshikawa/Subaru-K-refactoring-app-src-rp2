
package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {

    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}