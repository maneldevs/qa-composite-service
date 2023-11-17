package es.maneldevs.qa.qacompositeservice.application.out;

import es.maneldevs.qa.qacompositeservice.application.model.dto.UserDto;

public interface UserPort {
    UserDto getUser(String username);
}
