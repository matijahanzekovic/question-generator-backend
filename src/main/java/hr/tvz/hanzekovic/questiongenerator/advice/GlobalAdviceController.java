package hr.tvz.hanzekovic.questiongenerator.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class GlobalAdviceController {

    @ExceptionHandler({
            IllegalStateException.class,
            IllegalArgumentException.class,
            DataAccessException.class,
            EmptyResultDataAccessException.class,
            DataIntegrityViolationException.class
    })
    public ResponseEntity<String> handleBadRequestException(final RuntimeException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            NoSuchElementException.class,
            EntityNotFoundException.class
    })
    public ResponseEntity<String> handleNotFoundException(final RuntimeException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
