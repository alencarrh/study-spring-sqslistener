package com.arh.studies.sqslistener.configuration

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@Configuration
@RestController
class SwaggerConfiguration {

  @GetMapping("/") @Hidden
  fun swagger(): RedirectView = RedirectView("/swagger-ui")
}
