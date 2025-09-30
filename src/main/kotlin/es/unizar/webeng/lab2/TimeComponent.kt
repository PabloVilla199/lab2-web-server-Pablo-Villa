package es.unizar.webeng.lab2

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

/**
 * Data Transfer Object for time response
 */
data class TimeDTO(val time: LocalDateTime)

/**
 * Interface for providing time functionality
 */
interface TimeProvider {
    fun now(): LocalDateTime
}

/**
 * Service implementation for time operations
 */
@Service
class TimeService : TimeProvider {
    override fun now(): LocalDateTime = LocalDateTime.now()
}

/**
 * Extension function to convert LocalDateTime to DTO
 */
fun LocalDateTime.toDTO(): TimeDTO = TimeDTO(time = this)

/**
 * REST Controller for time endpoint
 */
@RestController
class TimeController(private val service: TimeProvider) {
    
    @GetMapping("/time")
    fun time(): TimeDTO = service.now().toDTO()
}