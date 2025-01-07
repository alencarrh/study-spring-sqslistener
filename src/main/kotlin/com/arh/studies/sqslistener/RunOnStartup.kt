package com.arh.studies.sqslistener

import io.awspring.cloud.sqs.annotation.SqsListener
import io.awspring.cloud.sqs.listener.MessageListenerContainerRegistry
import io.awspring.cloud.sqs.listener.SqsMessageListenerContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class RunOnStartup() : CommandLineRunner {

  @Autowired
  lateinit var listeners: List<MessageListenerContainerRegistry>

  override fun run(vararg args: String?) {
    println(listeners)
  }
}