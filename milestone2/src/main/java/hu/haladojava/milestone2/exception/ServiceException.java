package hu.haladojava.milestone2.exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -8929375067518736004L;
    
    public ServiceException(String message) {
        super(message);
    }
}
