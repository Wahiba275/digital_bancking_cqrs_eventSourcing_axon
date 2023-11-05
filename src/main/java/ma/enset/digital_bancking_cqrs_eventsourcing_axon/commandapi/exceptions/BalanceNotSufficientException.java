package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.exceptions;

public class BalanceNotSufficientException extends RuntimeException {
    public BalanceNotSufficientException(String message) {
        super(message);
    }
}
