package info.prorabka.vara.dto.response;

import info.prorabka.vara.entity.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ResponseResponse {

    private UUID id;
    private UUID adId;
    private UUID userId;
    private UserResponse user;
    private Response.ResponseStatus status;
    private String message;
    private LocalDateTime createdAt;
    @Schema(description = "Роль отклика (для объявлений 1.2)")
    private Response.ResponseRole responseRole;
}
