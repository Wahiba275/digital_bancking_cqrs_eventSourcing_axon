package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.commands;


import lombok.Getter;

public class CreditAccountCommand extends BaseCommand<String>{
  @Getter
  private double amount;
  @Getter
    private String currency;
    public CreditAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
