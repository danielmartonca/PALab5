package optional.exceptions;

public class FailedToCreateFileException extends Exception {
    public FailedToCreateFileException(String errorMessage) {
        super((errorMessage));
    }
}
