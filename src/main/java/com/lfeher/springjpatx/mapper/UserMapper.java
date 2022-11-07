package com.lfeher.springjpatx.mapper;

import com.lfeher.springjpatx.model.dto.UserDto;
import com.lfeher.springjpatx.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toUser(UserDto source);

    UserDto toUserDto(User source);
}
