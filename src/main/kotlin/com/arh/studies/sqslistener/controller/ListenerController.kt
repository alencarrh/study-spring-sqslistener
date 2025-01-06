package com.arh.studies.sqslistener.controller

import io.awspring.cloud.sqs.listener.MessageListenerContainerRegistry
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/listener")
class ListenerController(private val listenerRegistry: MessageListenerContainerRegistry) {

    private val logger = KotlinLogging.logger {}

    @PostMapping("/start/{id}")
    fun startListener(@PathVariable id: String) {
        CompletableFuture.runAsync {
            listenerRegistry.getContainerById(id)?.start()
        }
        logger.info { "Listener $id started" }
    }

    @PostMapping("/stop/{id}")
    fun stopListener(@PathVariable id: String) {
        CompletableFuture.runAsync {
            listenerRegistry.getContainerById(id)?.stop()
        }
        logger.info { "Listener $id stopped" }
    }
}
