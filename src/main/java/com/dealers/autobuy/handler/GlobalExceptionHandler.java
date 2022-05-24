package com.dealers.autobuy.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.dealers.autobuy.json.JsonResult;

/**
 * Advice Rest Controller for Global Exception Handling
 * @author Ali Golkar
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles all the untreated exceptions, log and send an email to the dev team
     * @param exception thrown exception
     * @param request   httpServletRequest
     * @return JsonResult
     */
    @ExceptionHandler({Exception.class})
    public JsonResult handleGlobalException(Exception exception, HttpServletRequest request) {
        logger.error("Server Error for request: " + request.getRequestURI() + ", Caused by: " + exception.getCause());
        return JsonResult.create(JsonResult.STATUS_EXCEPTION,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Server Error for request: " + request.getRequestURI() + ", Caused by: " + exception.getCause());
    }
}
