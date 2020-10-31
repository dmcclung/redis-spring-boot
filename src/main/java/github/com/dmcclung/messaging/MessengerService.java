package github.com.dmcclung.messaging;

public interface MessengerService {
    public long publishMessage(String message);
    public long getCount();
    public boolean isReceiverActive();
}
