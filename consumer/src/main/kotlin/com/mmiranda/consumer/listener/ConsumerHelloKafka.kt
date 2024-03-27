package com.mmiranda.consumer.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener

class ConsumerHelloKafka {

    companion object {
        private val logger = LoggerFactory.getLogger(ConsumerHelloKafka::class.java)
    }

    @KafkaListener(topics = ["\${topic-hello-kafka}"], groupId = "group_id")
    fun consume(message: String) {
        logger.info("Consumindo mensagem -> $message")
    }

}