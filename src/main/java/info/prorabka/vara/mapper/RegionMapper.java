package info.prorabka.vara.mapper;

import info.prorabka.vara.dto.response.RegionResponse;
import info.prorabka.vara.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {CountryMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegionMapper {

    RegionResponse toResponse(Region region);
}
