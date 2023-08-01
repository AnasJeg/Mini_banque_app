package ma.banque.app.entity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final RedisTemplate<String, String> redisTemplate;
    private final String channel = "B1269ADE-CA3C-48AA-B22A-6DAFF3DA1113";

    public MessagePublisher(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publishMessage(String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
