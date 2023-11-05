package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events;


import lombok.Getter;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.enums.AccountStatus;


public class AccountActivatedEvent extends BaseEvent<String>{
   @Getter private AccountStatus status;


    public AccountActivatedEvent(String id , AccountStatus status) {
        super(id);
        this.status = status;
    }



}
