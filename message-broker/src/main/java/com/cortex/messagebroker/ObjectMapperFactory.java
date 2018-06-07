package com.cortex.messagebroker;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public abstract class ObjectMapperFactory {

    /**
     * ObjectMapper padrao, ignora propriedades desconhecidas ou nulas e utiliza
     * como formato de data ISO8601
     */
    public static ObjectMapper get() {
        return new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(Include.NON_NULL)
            .setDateFormat(new ISO8601DateFormat());
    }

    /**
     * ObjectMapper que serializa de forma agressiva textos no formato ISO8601
     * em datas.
     */
    public static ObjectMapper getWithDateDeserializer() {
        ObjectMapper mapper = get();
        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addDeserializer(Object.class, new ISO8601DateDeseralizer());
        mapper.registerModule(simpleModule);

        return mapper;
    }
}
