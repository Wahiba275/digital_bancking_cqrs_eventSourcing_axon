package ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.enums.AccountStatus;


import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Account {
    @Id
    private String id ;
    private double balance ;
    @Enumerated(EnumType.STRING)
    private AccountStatus status ;
    private String currency ;
    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;

}
