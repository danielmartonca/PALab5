package compulsory.exceptions;

public class FailedToCreateFileException extends Exception {
    public FailedToCreateFileException(String errorMessage) {
        super((errorMessage));
    }
}
