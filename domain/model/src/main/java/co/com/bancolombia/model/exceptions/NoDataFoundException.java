package co.com.bancolombia.model.exceptions;


public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super("No data found");
    }
}
