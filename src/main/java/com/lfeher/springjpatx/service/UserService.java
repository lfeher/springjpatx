package com.lfeher.springjpatx.service;

import com.lfeher.springjpatx.mapper.UserMapper;
import com.lfeher.springjpatx.model.dto.UserDto;
import com.lfeher.springjpatx.model.entity.User;
import com.lfeher.springjpatx.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        return repository.findAll().stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        return repository.findById(id).map(userMapper::toUserDto).orElseThrow(() -> new EntityNotFoundException(String.format("Entity not found by id: %s", id)));
    }

    @Transactional
    public UserDto save(UserDto userDto) {
        final User user = userMapper.toUser(userDto);
        repository.save(user);
        return userMapper.toUserDto(user);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
