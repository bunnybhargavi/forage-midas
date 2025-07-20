package com.jpmc.midascore;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.jpmc.midascore.foundation.Transaction;

@Service
public class TransactionListener {

    @Value("${general.kafka-topic}")
    private String topic;

    // This method listens for messages and auto-deserializes them to Transaction
    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Transaction transaction) {
        System.out.println("Received Transaction: " + transaction);
    }
}
