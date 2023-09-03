package com.diegodev.ditech.domain.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
@Slf4j
public class PricesErrorAttributes extends DefaultErrorAttributes {

    private static final String TRACE = "trace";
    private static final String LOCALE = "locale";

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        final Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options.including(ErrorAttributeOptions.Include.values()));
        log.error("Error! Trace: {}", errorAttributes.get(TRACE));
        errorAttributes.put(LOCALE, webRequest.getLocale().toString());
        errorAttributes.remove(TRACE);

        return errorAttributes;
    }

}