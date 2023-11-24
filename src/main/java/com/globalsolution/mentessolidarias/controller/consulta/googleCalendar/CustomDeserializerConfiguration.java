package com.globalsolution.mentessolidarias.controller.consulta.googleCalendar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.globalsolution.mentessolidarias.controller.consulta.googleCalendar.CustomLongDeserializer;

public class CustomDeserializerConfiguration {
    public static void configureCustomDeserialization(ObjectMapper objectMapper) {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Long.class, new CustomLongDeserializer());
        objectMapper.registerModule(module);
    }
}
