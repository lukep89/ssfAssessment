package ibf2022.ssfAssessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import ibf2022.ssfAssessment.model.Order;
import ibf2022.ssfAssessment.model.Select;
import jakarta.validation.Valid;

@Service
public class PizzaService {

    private static final String DETAILS = "details";
    // private int count = 0;

    

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // save the pizza details to List in redis
    public void savePizza(final Select pizza) {
        redisTemplate.opsForList().leftPush(DETAILS, pizza);
        // redisTemplate.opsForList().leftPush(ORDER + "_" + count, pizza);
        // count++;

        System.out.println(redisTemplate.opsForList().leftPush(DETAILS, pizza));
    }

    // get 1st index of List then push order details
    public void saveOrder(final Order order) {
        redisTemplate.opsForList().leftPush(DETAILS, order);
    }

   

}
