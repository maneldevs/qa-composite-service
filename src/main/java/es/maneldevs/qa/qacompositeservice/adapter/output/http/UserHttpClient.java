package es.maneldevs.qa.qacompositeservice.adapter.output.http;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import es.maneldevs.qa.qacompositeservice.application.model.dto.UserDto;
import es.maneldevs.qa.qacompositeservice.application.out.UserPort;
import es.maneldevs.qa.qacompositeservice.config.MicroservicesConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserHttpClient implements UserPort {
    private final RestTemplate restTemplate;
    private final MicroservicesConfigProperties props;
    
    @Override
    public UserDto getUser(String username) {
        UserDto userDto = new UserDto();
        String url = props.getUserServiceUrlBase() + "/users/" + username;
        try {
            userDto = restTemplate.getForObject(url, UserDto.class);
        } catch (Exception e) {
            log.warn("Error calling {}", url);
            userDto.setUsername(username);
        }
        return userDto;
    }
    
}
