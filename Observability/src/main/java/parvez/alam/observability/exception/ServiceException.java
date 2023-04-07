package parvez.alam.observability.exception;

public class ServiceException extends Exception {
    public ServiceException(String error_occurred) {
        super(error_occurred);
    }
}
