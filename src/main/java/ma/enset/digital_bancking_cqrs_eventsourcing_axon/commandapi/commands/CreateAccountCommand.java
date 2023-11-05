package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.commands;


import lombok.Getter;

public class CreateAccountCommand extends BaseCommand<String>{
    @Getter private double intialBalance;
    @Getter private String currency;
    public CreateAccountCommand(String id, double intialBalance, String currency) {
        super(id);
        this.intialBalance = intialBalance;
        this.currency = currency;
    }
}
