package com.psc.j2021.util;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.*;

// 잘못된 코드임 static 에다 값을 넣으면 되냐... 이 생각 없는 놈아 ㅋㅋㅋ
//@Plugin(name = "TraceIdConverter", category = "Converter")
//@ConverterKeys({"traceId"})
public class TraceIdConverter extends LogEventPatternConverter {

    public static String traceId = "";

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
        if (traceId == null || traceId.equals("")) {
            traceId = "-";
        }
        return traceId;
    }
}