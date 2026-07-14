package info.prorabka.vara.event;

import info.prorabka.vara.entity.Ad;
import org.springframework.context.ApplicationEvent;

public class AdCreatedEvent extends ApplicationEvent {
    private final Ad ad;

    public AdCreatedEvent(Ad ad) {
        super(ad);
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }
}
