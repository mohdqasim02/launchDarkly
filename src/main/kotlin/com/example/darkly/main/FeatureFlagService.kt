package com.example.darkly.main

import com.launchdarkly.sdk.ContextKind
import com.launchdarkly.sdk.LDContext
import com.launchdarkly.sdk.server.LDClient
import org.springframework.stereotype.Service

@Service
class FeatureFlagService(
  private val ldClient: LDClient,
  private val ldContext: LDContext
) {
  fun isToggleOn(flag: FeatureFlag, defaultValue: Boolean = false): Boolean {
    return ldClient.boolVariation(flag.key, ldContext, defaultValue)
  }

  fun isToggleOn(flag: FeatureFlag, defaultValue: Boolean = false, context: LDContext): Boolean {
    return ldClient.boolVariation(flag.key, context, defaultValue)
  }

  fun createContext(key: String, name: String, kind: String = ""): LDContext {
    val contextKind = ContextKind.of(kind)
    return LDContext.builder(contextKind, key).name(name).build()
  }
}