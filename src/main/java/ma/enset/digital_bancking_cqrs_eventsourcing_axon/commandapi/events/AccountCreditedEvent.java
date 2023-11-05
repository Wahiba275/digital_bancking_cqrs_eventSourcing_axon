package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events;

import lombok.Getter;

public class AccountCreditedEvent extends BaseEvent<String>{

   @Getter private double amount;
    @Getter private String currency;
    public AccountCreditedEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
