package pl.pjatk.MovieService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pjatk.MovieService.exception.MovieException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieException.class)
    public ResponseEntity<Object> handleMovieException(MovieException ex) {
        return new ResponseEntity<>(ex.toString(), HttpStatus.BAD_REQUEST);
    }
}