package info.prorabka.vara.dto.request;

import info.prorabka.vara.entity.Advertisement;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdvertisementStatusRequest {
    @NotNull
    private Advertisement.AdvertisementStatus status;
}