package info.prorabka.vara.service;

import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FcmService {
    private final FcmTokenService fcmTokenService;

    /**
     * Отправляет "тихое" data-уведомление, чтобы разбудить приложение.
     * @param userId ID пользователя
     */
    public void sendWakeUpNotification(UUID userId) {
        List<String> tokens = fcmTokenService.getActiveTokensForUser(userId);
        if (tokens.isEmpty()) {
            log.warn("No active FCM tokens for user {}", userId);
            return;
        }
        for (String token : tokens) {
            Message message = Message.builder()
                    .setToken(token)
                    .putData("type", "WAKE_UP")
                    .build();
            try {
                String response = FirebaseMessaging.getInstance().send(message);
                log.info("Wake-up notification sent to user {} (token: {}), response: {}", userId, token, response);
            } catch (FirebaseMessagingException e) {
                if (e.getMessagingErrorCode() == MessagingErrorCode.UNREGISTERED) {
                    log.warn("FCM token unregistered: {}", token);
                    fcmTokenService.unregisterToken(userId, token);
                } else {
                    log.error("Failed to send FCM: {}", e.getMessage());
                }
            }
        }
    }

    /**
     * Пример отправки реального уведомления (опционально, как fallback).
     */
    public void sendRealNotification(UUID userId, String title, String body) {
        // 🔽 ДОБАВЬТЕ ЭТИ СТРОКИ
        List<String> tokens = fcmTokenService.getActiveTokensForUser(userId);
        log.info("📱 Отправка реального уведомления пользователю {}, найдено токенов: {}", userId, tokens.size());

        if (tokens.isEmpty()) {
            log.warn("⚠️ Нет активных FCM-токенов для пользователя {}", userId);
            return;
        }

        for (String token : tokens) {
            Message message = Message.builder()
                    .setToken(token)
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .build())
                    .putData("type", "REAL")          // или "ADMIN_MESSAGE"
                    .putData("messageId", "")         // можно добавить ID сообщения
                    .build();
            try {
                String response = FirebaseMessaging.getInstance().send(message);
                // 🔽 ДОБАВЬТЕ ЛОГ УСПЕШНОЙ ОТПРАВКИ
                log.info("✅ FCM отправлен пользователю {}, токен {}, ответ: {}", userId, token, response);
            } catch (FirebaseMessagingException e) {
                if (e.getMessagingErrorCode() == MessagingErrorCode.UNREGISTERED) {
                    log.warn("🔴 FCM токен недействителен: {}", token);
                    fcmTokenService.unregisterToken(userId, token);
                } else {
                    // 🔽 ДОБАВЬТЕ ПОДРОБНЫЙ ЛОГ ОШИБКИ
                    log.error("❌ Ошибка отправки FCM пользователю {}: {}", userId, e.getMessage(), e);
                }
            }
        }
    }
}