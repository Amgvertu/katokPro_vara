package info.prorabka.vara.mapper;

import info.prorabka.vara.dto.response.UserResponse;
import info.prorabka.vara.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResponse toResponse(User user);
}