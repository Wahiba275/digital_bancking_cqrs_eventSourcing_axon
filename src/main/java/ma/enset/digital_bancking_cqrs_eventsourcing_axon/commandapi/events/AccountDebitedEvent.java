package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events;

import lombok.Getter;

public class AccountDebitedEvent extends BaseEvent<String>{

   @Getter private double amount;
    @Getter private String currency;
    public AccountDebitedEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
