package info.prorabka.vara.controller;

import info.prorabka.vara.dto.request.FeedbackRequest;
import info.prorabka.vara.dto.response.ApiResponse;
import info.prorabka.vara.security.SecurityUser;
import info.prorabka.vara.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> sendFeedback(
            @AuthenticationPrincipal SecurityUser currentUser,
            @Valid @RequestBody FeedbackRequest request) {
        UUID userId = (currentUser != null) ? currentUser.getId() : null;
        feedbackService.sendFeedback(userId, request);
        return ResponseEntity.ok(ApiResponse.success("Сообщение отправлено", null));
    }
}