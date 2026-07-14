package info.prorabka.vara.dto.response;

import info.prorabka.vara.entity.DeliveryCriteria;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AdminMessageResponse {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    private String link;
    private String category;
    private DeliveryCriteria deliveryCriteria;
    private LocalDateTime createdAt;
    private int recipientCount; // количество получателей
}