package com.example.springsample.service.impl;

import com.example.springsample.entity.User;
import com.example.springsample.repository.UserRepository;
import com.example.springsample.service.UserService;
import com.example.springsample.vo.request.UserAddRequestVO;
import com.example.springsample.vo.request.UserUpdateRequestVO;
import com.example.springsample.vo.response.UserResponseVO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<UserResponseVO> getAll() {
    return userRepository.findAll()
        .stream()
        .map(user -> UserResponseVO.of(user))
        .collect(Collectors.toList());
  }

  @Override
  public UserResponseVO get(Long id) {
    return userRepository.findById(id)
        .map(user -> UserResponseVO.of(user))
        .stream()
        .findFirst()
        .orElse(null);
  }

  @Override
  public UserResponseVO add(UserAddRequestVO user) {
    return UserResponseVO.of(userRepository.save(User.of(user)));
  }

  @Override
  public UserResponseVO update(UserUpdateRequestVO user) {
    return UserResponseVO.of(userRepository.save(User.of(user)));
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

}
