package es.maneldevs.qa.qacompositeservice.application.model.response;

import es.maneldevs.qa.qacompositeservice.application.model.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponse {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;

    public UserResponse(UserDto userDto) {
        this.username = userDto.getUsername();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
    }
}
