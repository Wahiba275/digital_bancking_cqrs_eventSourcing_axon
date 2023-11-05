package ma.enset.digital_bancking_cqrs_eventsourcing_axon.commandapi.events;

public abstract class BaseEvent<T> {
    private T id ;

    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
