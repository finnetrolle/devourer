package ru.finnetrolle.devourer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class DevourerApplication

fun main(args: Array<String>) {
    SpringApplication.run(DevourerApplication::class.java, *args)
}
