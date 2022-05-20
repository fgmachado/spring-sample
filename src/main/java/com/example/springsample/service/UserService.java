package com.example.springsample.service;

import com.example.springsample.vo.request.UserAddRequestVO;
import com.example.springsample.vo.request.UserUpdateRequestVO;
import com.example.springsample.vo.response.UserResponseVO;
import java.util.List;

public interface UserService {

  List<UserResponseVO> getAll();

  UserResponseVO get(Long id);

  UserResponseVO add(UserAddRequestVO user);

  UserResponseVO update(UserUpdateRequestVO user);

  void delete(Long id);

}
