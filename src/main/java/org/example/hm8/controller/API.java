package org.example.hm8.controller;

import org.example.hm8.model.Project;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class API {

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public @interface NotFound {
        }

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Проект найден", responseCode = "200", content = @Content(schema = @Schema(implementation = Project.class)))
    public @interface Found {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Ошибка сервера", responseCode = "500", content = @Content(schema = @Schema(implementation = Void.class)))
    public @interface ServerError {
    }



}
