package info.prorabka.vara.event;

import info.prorabka.vara.entity.Response;
import org.springframework.context.ApplicationEvent;

public class ResponseCreatedEvent extends ApplicationEvent {
    private final Response response;

    public ResponseCreatedEvent(Response response) {
        super(response);
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}