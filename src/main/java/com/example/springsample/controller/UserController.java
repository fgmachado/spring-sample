package com.example.springsample.controller;

import com.example.springsample.service.UserService;
import com.example.springsample.vo.request.UserAddRequestVO;
import com.example.springsample.vo.request.UserUpdateRequestVO;
import com.example.springsample.vo.response.UserResponseVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<UserResponseVO> getUsers() {
    return userService.getAll();
  }

  @GetMapping("{id}")
  public UserResponseVO getUser(@PathVariable("id") Long id) {
    return userService.get(id);
  }

  @PostMapping
  public UserResponseVO addUser(@RequestBody UserAddRequestVO user) {
    return userService.add(user);
  }

  @PutMapping
  public UserResponseVO updateUser(@RequestBody UserUpdateRequestVO user) {
    return userService.update(user);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    userService.delete(id);
    return ResponseEntity.ok().build();
  }

}
