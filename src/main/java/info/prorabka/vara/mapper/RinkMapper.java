package info.prorabka.vara.mapper;

import info.prorabka.vara.dto.response.RinkResponse;
import info.prorabka.vara.entity.Rink;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {CountryMapper.class, RegionMapper.class, CityMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RinkMapper {

    RinkResponse toResponse(Rink rink);
}
