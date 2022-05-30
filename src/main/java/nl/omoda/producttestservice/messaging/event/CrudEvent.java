package nl.omoda.producttestservice.messaging.event;

public class CrudEvent<T> {
    private final String crudType;
    private final T payload;

    public CrudEvent(String crudType, T payload) {
        this.crudType = crudType;
        this.payload = payload;
    }

    public String getCrudType() {
        return this.crudType;
    }

    public T getPayload() {
        return this.payload;
    }

    @Override
    public String toString() {
        return "{" +
                " crudType='" + getCrudType() + "'" +
                ", payload='" + getPayload() + "'" +
                "}";
    }
}
