package ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.Controllers;


import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries.GetAccountByIdQuery;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries.GetAllAccountQuery;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.entities.Account;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/accounts")
public class QueryAccountController {
    private QueryGateway queryGateway ;
    @GetMapping("/allAccounts")
    public List<Account> accountList(){
        List<Account> response = queryGateway.query(new GetAllAccountQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
        return response;
    }

    @GetMapping("/byId/{id}")
    public Account getAccount(String id){
        Account response = queryGateway.query(new GetAccountByIdQuery(id), ResponseTypes.instanceOf(Account.class)).join();
        return response;
    }
}
