# Spring Sample

Spring Sample é uma aplicação simples, contruída para fins didáticos, que possui 
um CRUD de usuários.

A pretensão desta aplicação é apenas servir de guia para quem realmente 
está iniciando no desenvolvimento com Java e Spring Boot. 

## Ambiente e pré-requisitos

Para executar a aplicação você precisará de um banco de dados MySQL.
Dentro do diretório `.docker` há um `docker-compose.yml` 
que inicializa um container de MySQL.

Utilize o comando `docker-compose --file .docker/docker-compose.yml up` 
na raíz do projeto para inicializar o ambiente necessário para executar a aplicação.

A aplicação já está configurada para conectar neste banco e realizar as operações de CRUD.

## Entendendo a aplicação

Esta é uma aplicação Java, utilizando Maven como gerenciador de build e dependências.
Suas funcionalidades são bastante simples, existe um controller com alguns endpoints expostos.

### Pacote controller

Neste pacote está o `UserController`, classe responsável por expor 
os endpoints da aplicação.

É possível verificar algumas informações importantes nesta classe.
- `@RestController`: esta anotação (esteriótipo) diz para o Spring que esta classe 
representa um controller e que estará disponível como bean 
dentro do contexto do Spring.
- `@RequiredArgsConstructor`: recurso do Lombok que cria em tempo 
de compilação um construtor com todos os parâmetros obrigatórios da classe.
No caso, estes atributos são os que são definidos como `final`.
O motivo para esta anotação estar ai é para utilizar a injeção 
de dependências baseada no construtor da classe.
- `@RequestMapping("users")`: anotação responsável por definir qual será 
o path dos endpoints declarados nesta classe.

```java
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
```

### Doing...