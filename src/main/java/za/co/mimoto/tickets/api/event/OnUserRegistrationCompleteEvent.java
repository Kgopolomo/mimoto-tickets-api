package za.co.mimoto.tickets.api.event;


import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;
import za.co.mimoto.tickets.api.model.User;

public class OnUserRegistrationCompleteEvent extends ApplicationEvent {

    private transient UriComponentsBuilder redirectUrl;
    private User user;

    public OnUserRegistrationCompleteEvent(User user, UriComponentsBuilder redirectUrl) {
        super(user);
        this.user = user;
        this.redirectUrl = redirectUrl;
    }

    public UriComponentsBuilder getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(UriComponentsBuilder redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
