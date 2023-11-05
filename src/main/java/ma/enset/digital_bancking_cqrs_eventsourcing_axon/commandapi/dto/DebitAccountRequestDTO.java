package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.dto;

import lombok.Data;

@Data
public class DebitAccountRequestDTO {
    private String accountId;
    private double amount ;
    private String currency;

}
