package com.arh.studies.sqslistener.service.consumer

import io.awspring.cloud.sqs.annotation.SqsListener
import io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode.ON_SUCCESS
import io.awspring.cloud.sqs.operations.SqsTemplate
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Service

@Service
class ConsumerStringQueue(private val sqsTemplate: SqsTemplate) {

    private val logger = KotlinLogging.logger {}

    @SqsListener(id = "queue-1-consumer", value = ["queue-1"])
    fun listener(message: String, @Headers headers: Map<String, Any>) {
        //    val replyChannel = message.headers.replyChannel
        //    val errorChannel = message.headers.errorChannel
        logger.info { "Message received: $message" }
    }
}
