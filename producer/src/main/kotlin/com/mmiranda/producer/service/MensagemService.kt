package com.mmiranda.producer.service
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MensagemService(private val kafkaTemplate: KafkaTemplate<String, String>) {

    companion object {
        private val logger = LoggerFactory.getLogger(MensagemService::class.java)
    }

    @Value("\${topic.hello-kafka}")
    private lateinit var helloKafka: String

    fun sendMessage(message: String) {
        logger.info("Mensagem -> $message")
        kafkaTemplate.send(helloKafka, message)
    }
}
