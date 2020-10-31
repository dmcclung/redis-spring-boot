package github.com.dmcclung.messaging;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisMessengerService implements MessengerService {

    private static final Logger logger = LoggerFactory.getLogger(RedisMessengerService.class);

    @Autowired
    private ApplicationContext context;    

    @Autowired
    private Receiver receiver;

    private AtomicLong counter = new AtomicLong();
    
    @Override
    public long publishMessage(String message) {
        StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
        template.convertAndSend("chat", message);

        logger.info("StringRedisTemplate sent message");

        return counter.incrementAndGet();
    }

    @Override
    public long getCount() {
        return counter.get();
    }

    @Override
    public boolean isReceiverActive() {
        return receiver != null;
    }
    
}
