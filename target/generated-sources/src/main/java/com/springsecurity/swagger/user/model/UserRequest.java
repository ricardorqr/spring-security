package com.springsecurity.swagger.user.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.springsecurity.swagger.user.model.UserDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * User request
 */

@Schema(name = "UserRequest", description = "User request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserRequest   {

  @JsonProperty("name")
  private String name;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  public UserRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of ther user
   * @return name
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "name", example = "Ricardo Ribeiro", description = "Name of ther user", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Login of ther user
   * @return username
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "username", example = "ribeirorqr", description = "Login of ther user", required = true)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of ther user
   * @return password
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "password", example = "ricardo123", description = "Password of ther user", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRequest userRequest = (UserRequest) o;
    return Objects.equals(this.name, userRequest.name) &&
        Objects.equals(this.username, userRequest.username) &&
        Objects.equals(this.password, userRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

