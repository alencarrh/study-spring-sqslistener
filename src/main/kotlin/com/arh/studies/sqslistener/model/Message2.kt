package com.arh.studies.sqslistener.model

import jakarta.validation.constraints.Min

data class Message2(
  @Min(10) private val count: Int,
  private val something: String
)
