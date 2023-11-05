package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class GetAccountByIdQuery {
    public String id ;
}
