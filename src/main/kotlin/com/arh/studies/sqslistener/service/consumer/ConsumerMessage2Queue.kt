package com.arh.studies.sqslistener.service.consumer

import com.arh.studies.sqslistener.model.Message2
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Headers

class ConsumerMessage2Queue {


    @SqsListener(id = "queue-2-consumer", value = ["queue-2"])
    fun listener(message: Message2, @Headers headers: Map<String, Any>) {

    }

}