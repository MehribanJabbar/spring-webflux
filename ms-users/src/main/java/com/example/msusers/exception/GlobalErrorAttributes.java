package com.example.msusers.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(
                request, options);
        errorAttributes.put("message", ErrorMessage.UNEXPECTED_ERROR.getMessage());
        errorAttributes.put("path", request.path());
        errorAttributes.put("error", "Internal Server Error");
        return errorAttributes;
    }

}
