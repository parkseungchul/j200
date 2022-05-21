package com.psc.j2021.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Plugin(name = "TraceIdConverter", category = "Converter")
@ConverterKeys({"traceId"})
public class TraceIdConverter2 extends LogEventPatternConverter {
    private TraceIdConverter2(final String name, final String style) {
        super(name, style);
    }
    public static TraceIdConverter2 newInstance(final String[] options) {
        return new TraceIdConverter2("traceId", "traceId");
    }
    @Override
    public void format(final LogEvent event, final StringBuilder toAppendTo) {
        String traceId = null;
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if(request != null){
                traceId = (String) request.getSession().getAttribute("traceId");
            }
        }catch (Exception e){
            log.warn(e.getMessage());
        }
        toAppendTo.append( (traceId == null||traceId.equals(""))?"":traceId);
    }

}
