package pl.jm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

@Configuration
public class TestClockConfig {

    public static final Instant TEST_TIME = Instant.parse("2018-01-01T00:00:00Z");

    /**
     * Overrides real-time clock with a fixed-time clock for deterministic testing.
     */
    @Primary
    @Bean
    public Clock testClock() {
        return Clock.fixed(TEST_TIME, ZoneOffset.UTC);
    }
}
