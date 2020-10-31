package github.com.dmcclung.messaging;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No message")
public class MessageNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
        
}
