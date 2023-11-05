package ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.enums.OperationType;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events.AccountActivatedEvent;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events.AccountCreatedEvent;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events.AccountCreditedEvent;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events.AccountDebitedEvent;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries.GetAccountByIdQuery;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.queries.GetAllAccountQuery;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.entities.Account;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.entities.Operation;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.repositories.AccountRepository;
import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.repositories.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;
    @EventHandler
    public void on(AccountCreatedEvent event){
        log.info("********************************");
        log.info("AccountCreatedEvent received");
        Account account = new Account();
        account.setId(event.getId());
        account.setBalance(event.getInitialBalance());
        account.setCurrency(event.getCurrency());
        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent event){
        log.info("********************************");
        log.info("AccountActivatedEvent received");
        Account account = accountRepository.findById(event.getId()).get();
        account.setStatus(event.getStatus());
        accountRepository.save(account);

    }

    @EventHandler
    public void on(AccountDebitedEvent event){
        log.info("********************************");
        log.info("AccountDebitedEvent received");
        Account account = accountRepository.findById(event.getId()).get();
        Operation operation = new Operation();
        operation.setAmount(event.getAmount());
        operation.setDate(new Date());// à ne pas faire
        operation.setType(OperationType.DEBIT);
        operation.setAccount(account);
        operationRepository.save(operation);
        account.setBalance(account.getBalance()- event.getAmount());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountCreditedEvent event){
        log.info("********************************");
        log.info("AccountCreditedEvent received");
        Account account = accountRepository.findById(event.getId()).get();
        Operation operation = new Operation();
        operation.setAmount(event.getAmount());
        operation.setDate(new Date());// à ne pas faire
        operation.setType(OperationType.DEBIT);
        operation.setAccount(account);
        operationRepository.save(operation);
        account.setBalance(account.getBalance()+event.getAmount());
        accountRepository.save(account);

    }

    @QueryHandler
    public List<Account> on(GetAllAccountQuery query){
             return accountRepository.findAll();
    }
    @QueryHandler
    public Account on(GetAccountByIdQuery query){
        return accountRepository.findById(query.getId()).get();
    }

}
