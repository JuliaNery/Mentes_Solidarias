package com.globalsolution.mentessolidarias.controller.consulta.googleCalendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public final class CustomLongDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Faça a lógica para desserialização, considerando a possibilidade de ser Integer ou Long
        // Exemplo:
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);
        if (node.isInt()) {
            return node.asLong();
        } else if (node.isLong()) {
            return node.asLong();
        } else {
            throw new IOException("Tipo inesperado para expiresInSeconds");
        }
    }

    @JsonDeserialize(using = CustomLongDeserializer.class)
    private Long expiresInSeconds;
}
