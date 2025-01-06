package com.arh.studies.sqslistener.service.producer

import io.awspring.cloud.sqs.operations.SqsTemplate
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class ProducerStringQueue(private val sqsTemplate: SqsTemplate) {

  private var i = 0
  private val logger = KotlinLogging.logger {}
  private var isActive = false

  fun produce() {
    while (isActive) {
      sqsTemplate.send("queue-1", "Message ${i++}")
      logger.info { "Message sent: Message $i" }
      sqsTemplate.send() { to -> to.queue("queue-1").payload("Message ${i++}") }
      logger.info { "Message sent: Message $i" }
      Thread.sleep(1000)
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
