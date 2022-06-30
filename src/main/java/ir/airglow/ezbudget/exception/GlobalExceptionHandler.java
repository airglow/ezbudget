package ir.airglow.ezbudget.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, Object> entityNotFoundException(EntityNotFoundException exception) {

        log.error("Entity Not Found Exception"
                + " # Class Name: " + exception.getStackTrace()[1].getClassName()
                + " # Method Name: " + exception.getStackTrace()[1].getMethodName()
                + " # Line Number: " + exception.getStackTrace()[1].getLineNumber());

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Entity Not Found.");

        return response;
    }
}
