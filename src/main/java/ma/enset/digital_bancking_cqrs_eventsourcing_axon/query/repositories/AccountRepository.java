package ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.repositories;


import ma.enset.digital_bancking_cqrs_eventsourcing_axon.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<Account,String> {


}
