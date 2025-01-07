package com.arh.studies.sqslistener.service.producer

import com.arh.studies.sqslistener.model.Message2
import io.awspring.cloud.sqs.operations.SqsTemplate
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class ProducerMessageQueue2(private val sqsTemplate: SqsTemplate) {

  private var i = 0
  private val logger = KotlinLogging.logger {}
  private var isActive = false

  fun produce() {
    while (isActive) {
      sqsTemplate.send("queue-2", Message2(count = i++, something = "A"))
      logger.info { "QUEUE-2:: Message sent: Message $i" }
      sqsTemplate.send() { to -> to.queue("queue-2").payload(Message2(count = i++, something = "B")) }
      logger.info { "QUEUE-2:: Message sent: Message $i" }
      Thread.sleep(2000)
    }
  }

  fun stop() {
    isActive = false
  }

  fun start() {
    isActive = true
    produce()
  }
}
