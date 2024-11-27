package com.example.darkly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DarklyApplication

fun main(args: Array<String>) {
	runApplication<DarklyApplication>(*args)
}
