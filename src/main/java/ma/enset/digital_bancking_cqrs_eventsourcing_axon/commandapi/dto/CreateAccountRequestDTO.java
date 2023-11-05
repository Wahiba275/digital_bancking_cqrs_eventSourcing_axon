package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   @NoArgsConstructor @AllArgsConstructor
public class CreateAccountRequestDTO {
    private double initialBalance;
    private String currency;
}
