package com.example.springsample.vo.response;

import com.example.springsample.entity.User;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseVO {

  private Long id;
  private String name;
  private String email;

  public static UserResponseVO of(final User user) {
    if (Objects.isNull(user)) {
      return null;
    }

    return UserResponseVO.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .build();
  }

}
