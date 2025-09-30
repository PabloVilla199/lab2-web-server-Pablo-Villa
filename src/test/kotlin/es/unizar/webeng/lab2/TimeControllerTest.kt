package es.unizar.webeng.lab2

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDateTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TimeControllerTest {

    @LocalServerPort
    private var port: Int = 0

    private val restTemplate = TestRestTemplate()

    @Test
    fun `should return current time with valid datetime`() {
        // Arrange
        val now = LocalDateTime.now()
        
        // Act
        val response = restTemplate.getForEntity("http://localhost:$port/time", TimeDTO::class.java)
        
        // Assert
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isNotNull
        assertThat(response.body?.time).isNotNull
        assertThat(response.body?.time?.year).isEqualTo(now.year)
        assertThat(response.body?.time?.month).isEqualTo(now.month)
        assertThat(response.body?.time?.dayOfMonth).isEqualTo(now.dayOfMonth)
        assertThat(response.body?.time?.hour).isEqualTo(now.hour)
        assertThat(response.body?.time?.minute).isIn(now.minute - 1, now.minute, now.minute + 1)
    }
}