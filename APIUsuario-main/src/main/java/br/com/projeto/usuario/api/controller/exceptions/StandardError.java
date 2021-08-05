package br.com.projeto.usuario.api.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@Data
public class StandardError {

    /**
     * "timestamp": "2021-02-02T00:21:24.555+00:00",
     * "status": 500,
     * "error":"Internal Server Error",
     * "message": "",
     * "path": "/users/7"
     **/

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'Z'", timezone = "GMT")
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}
