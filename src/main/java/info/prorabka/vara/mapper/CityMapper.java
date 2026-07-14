package info.prorabka.vara.mapper;

import info.prorabka.vara.dto.response.CityResponse;
import info.prorabka.vara.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {RegionMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    CityResponse toResponse(City city);
}
