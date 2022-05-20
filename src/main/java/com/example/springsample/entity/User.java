package com.example.springsample.entity;

import com.example.springsample.vo.request.UserAddRequestVO;
import com.example.springsample.vo.request.UserUpdateRequestVO;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;

  public static User of(final UserAddRequestVO user) {
    if (Objects.isNull(user)) {
      return null;
    }

    return User.builder()
        .name(user.getName())
        .email(user.getEmail())
        .build();
  }

  public static User of(final UserUpdateRequestVO user) {
    if (Objects.isNull(user)) {
      return null;
    }

    return User.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .build();
  }

}
