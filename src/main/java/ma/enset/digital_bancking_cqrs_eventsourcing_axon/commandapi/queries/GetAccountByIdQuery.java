package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetAccountByIdQuery {
    public String id ;
    public GetAccountByIdQuery(String id ){
        this.id=id;
    }
}
