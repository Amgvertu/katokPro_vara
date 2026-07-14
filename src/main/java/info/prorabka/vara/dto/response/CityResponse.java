package info.prorabka.vara.dto.response;

import lombok.Data;

@Data
public class CityResponse {

    private Long id;
    private String name;
    private RegionResponse region;
}
