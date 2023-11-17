package es.maneldevs.qa.qacompositeservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@ConfigurationProperties(prefix = "microservices")
@AllArgsConstructor
@Getter
public class MicroservicesConfigProperties {
    private final String userServiceHost;
    private final String userServicePort;
    private final String qaServiceHost;
    private final String qaServicePort;
    private final String gameServiceHost;
    private final String gameServicePort;

    public String getUserServiceUrlBase() {
        return userServiceHost + ":" + userServicePort;
    }

    public String getQAServiceUrlBase() {
        return qaServiceHost + ":" + qaServicePort;
    }

    public String getGameServiceUrlBase() {
        return gameServiceHost + ":" + gameServicePort;
    }
}
