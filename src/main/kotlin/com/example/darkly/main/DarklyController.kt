package com.example.darkly.main

import com.example.darkly.main.FeatureFlag.FIRST_TOGGLE
import com.example.darkly.main.FeatureFlag.SECOND_TOGGLE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LaunchDarklyController(
  private val featureFlagService: FeatureFlagService
) {

  @GetMapping("/api/launch-darkly")
  fun getLaunchDarklyFlag(): ResponseEntity<String> {
    val isToggleOn = featureFlagService.isToggleOn(FIRST_TOGGLE)

    if (isToggleOn) {
      return ResponseEntity.ok("$FIRST_TOGGLE is ON!")
    }
    return ResponseEntity.ok("$FIRST_TOGGLE is OFF!")
  }

  @GetMapping("/api/launch-darkly/{user}")
  fun getLaunchDarklyFlag(@PathVariable user: String): ResponseEntity<String> {
    val context = featureFlagService.createContext(user, user)
    val isToggleOn = featureFlagService.isToggleOn(SECOND_TOGGLE, false, context)

    if (isToggleOn) {
      return ResponseEntity.ok("$SECOND_TOGGLE is ON for $user!")
    }

    return ResponseEntity.ok("$SECOND_TOGGLE is OFF for $user!")
  }
}
