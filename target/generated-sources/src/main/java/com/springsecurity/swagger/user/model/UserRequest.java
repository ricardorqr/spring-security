package com.springsecurity.swagger.user.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.springsecurity.swagger.user.model.RoleDTO;
import com.springsecurity.swagger.user.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
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

  @JsonProperty("roles")
  @Valid
  private List<RoleDTO> roles = null;

  public UserRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * User's name
   * @return name
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "name", example = "Ricardo Ribeiro", description = "User's name", required = true)
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
   * User's login
   * @return username
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "username", example = "ribeirorqr", description = "User's login", required = true)
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
   * User's password
   * @return password
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "password", example = "ricardo123", description = "User's password", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRequest roles(List<RoleDTO> roles) {
    this.roles = roles;
    return this;
  }

  public UserRequest addRolesItem(RoleDTO rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
  */
  @Valid 
  @Schema(name = "roles", required = false)
  public List<RoleDTO> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleDTO> roles) {
    this.roles = roles;
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
        Objects.equals(this.password, userRequest.password) &&
        Objects.equals(this.roles, userRequest.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, username, password, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

