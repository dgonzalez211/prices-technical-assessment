package com.diegodev.ditech.domain.handlers;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public interface ErrorAttributesHandler {
    Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options);
}