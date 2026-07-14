package info.prorabka.vara.dto.response;

import info.prorabka.vara.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponse {

    private UUID id;
    private String phone;
    private User.UserRole role;
    private User.UserSubrole subrole;
    private User.UserStatus status;
    private LocalDateTime registeredAt;
    private LocalDateTime lastLoginAt;
    private ProfileResponse profile;
}
