package ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.Controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries.GetAccountByIdQuery;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries.GetAllAccountQuery;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.entities.Account;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/query/accounts")
@AllArgsConstructor
@Slf4j
public class QueryAccountController {
    private QueryGateway queryGateway;

    @GetMapping("/allAccounts")
    public List<Account> accounts() {
        log.info("Handling a AccountCreatedEvent command with information:");
        return queryGateway.query(new GetAllAccountQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
    }

    @GetMapping("byId/{id}")
    public Account accountById(@PathVariable String id) {
        log.info("Handling a AccountCreatedEvent command with information:");
        return queryGateway.query(new GetAccountByIdQuery(id), ResponseTypes.instanceOf(Account.class)).join();
    }
}