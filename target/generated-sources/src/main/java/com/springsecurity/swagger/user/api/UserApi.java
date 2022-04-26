/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.springsecurity.swagger.user.api;

import com.springsecurity.swagger.user.model.Error;
import com.springsecurity.swagger.user.model.UserRequest;
import com.springsecurity.swagger.user.model.UserResponse;
import com.springsecurity.swagger.user.model.UsersAndRolesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "User", description = "the User API")
public interface UserApi {

    /**
     * POST /users : Add a user
     *
     * @param userRequest Details of the user (required)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Not Found (status code 404)
     *         or System Error (status code 500)
     */
    @Operation(
        operationId = "addUser",
        summary = "Add a user",
        tags = { "User" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  UserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class))),
            @ApiResponse(responseCode = "500", description = "System Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/users",
        produces = "application/json",
        consumes = "application/json"
    )
    ResponseEntity<UserResponse> addUser(
        @Parameter(name = "UserRequest", description = "Details of the user", required = true, schema = @Schema(description = "")) @Valid @RequestBody UserRequest userRequest
    );


    /**
     * GET /users : Get all users
     *
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Not Found (status code 404)
     *         or System Error (status code 500)
     */
    @Operation(
        operationId = "getUsers",
        summary = "Get all users",
        tags = { "User" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  UsersAndRolesResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class))),
            @ApiResponse(responseCode = "500", description = "System Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Error.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users",
        produces = "application/json"
    )
    ResponseEntity<UsersAndRolesResponse> getUsers(
        
    );

}
