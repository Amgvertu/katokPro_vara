package info.prorabka.vara.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileSimpleResponse {
    private String firstName;
    private String lastName;
    private String team;
    private CitySimpleResponse homeCity;
}