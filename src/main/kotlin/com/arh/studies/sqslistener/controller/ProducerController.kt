package com.arh.studies.sqslistener.controller

import com.arh.studies.sqslistener.service.producer.ProducerMessageQueue2
import com.arh.studies.sqslistener.service.producer.ProducerStringQueue
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/producer")
class ProducerController(
  private val producer: ProducerStringQueue,
  private val producer2: ProducerMessageQueue2
) {

  private val logger = KotlinLogging.logger {}

  @PostMapping("/start")
  fun startListener() {
    CompletableFuture.runAsync { producer.start() }
    CompletableFuture.runAsync { producer2.start() }
    logger.info { "Producer started" }
  }

  @PostMapping("/stop")
  fun stopListener() {
    CompletableFuture.runAsync { producer.stop() }
    CompletableFuture.runAsync { producer2.stop() }
    logger.info { "Producer stopped" }
  }
}
