package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.exceptions;

public class AmountNegativeException extends RuntimeException {
    public AmountNegativeException(String message) {
            super(message);
    }
}
