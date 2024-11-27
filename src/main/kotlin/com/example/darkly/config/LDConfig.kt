package com.example.darkly.config

import com.launchdarkly.sdk.LDContext
import com.launchdarkly.sdk.server.LDClient
import com.launchdarkly.sdk.server.LDConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LaunchDarklyConfig(
  @Value("\${launchdarkly.sdk.key}")
  private val sdkKey: String
) {
  @Bean
  fun ldClient(): LDClient {
    val ldConfig = LDConfig.Builder().build()

    return LDClient(sdkKey, ldConfig)
  }

  @Bean
  fun ldContext(): LDContext = LDContext.builder("anonymous").anonymous(true).build()
}

