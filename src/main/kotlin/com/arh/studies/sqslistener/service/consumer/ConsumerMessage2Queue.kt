package com.arh.studies.sqslistener.service.consumer

import com.arh.studies.sqslistener.model.Message2
import io.awspring.cloud.sqs.annotation.SqsListener
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Service

@Service
class ConsumerMessage2Queue {

  private val logger = KotlinLogging.logger {}

  @SqsListener(id = "queue-2-consumer", value = ["queue-2"])
  fun listener(message: Message2, @Headers headers: Map<String, Any>) {
    println(message.toString())

    logger.info { "QUEUE-2 : ${message.toString()} " }
  }

}