package com.esee1rg.rabbitappconsume;

import com.esee1rg.rabbitappconsume.configs.MQConfig;
import com.esee1rg.rabbitappconsume.repositories.FirstRepository;
import com.esee1rg.rabbitappconsume.repositories.SecondRepository;
import com.esee1rg.rabbitappconsume.repositories.ThirdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

   private final FirstRepository firstRepository;
   private final SecondRepository secondRepository;
   private final ThirdRepository thirdRepository;
   private final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Autowired
    public MessageListener(FirstRepository firstRepository, SecondRepository secondRepository,
                           ThirdRepository thirdRepository) {
        this.firstRepository = firstRepository;
        this.secondRepository = secondRepository;
        this.thirdRepository = thirdRepository;
    }

    @RabbitListener(queues = MQConfig.QUEUE1)
    public void listener1(String message) {
        firstRepository.save(message);
        logger.info("Received message from queue 1: " + message);}

    @RabbitListener(queues = MQConfig.QUEUE2)
    public void listener2(String message) {
        secondRepository.save(message);
        logger.info("Received message from queue 2: " + message);
    }

    @RabbitListener(queues = MQConfig.QUEUE3)
    public void listener3(String message) {
        thirdRepository.save(message);
        logger.info("Received message from queue 3: " + message);
    }
}
