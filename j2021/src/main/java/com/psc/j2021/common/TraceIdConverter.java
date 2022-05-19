package com.psc.j2021.common;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.*;

@Plugin(name = "TraceIdConverter", category = "Converter")
@ConverterKeys({"traceId"})
public class TraceIdConverter extends LogEventPatternConverter {

    static String traceId = "";

    private TraceIdConverter(final String name, final String style) {
        super(name, style);
    }

    public static TraceIdConverter newInstance(final String[] options) {
        return new TraceIdConverter("traceId", "traceId");
    }

    @Override
    public void format(final LogEvent event, final StringBuilder toAppendTo) {
        toAppendTo.append(getTraceId());
    }

    private String getTraceId() {
        if (traceId == null) {
            traceId = "-";
        }
        return traceId;
    }
}