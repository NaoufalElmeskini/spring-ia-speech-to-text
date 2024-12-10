package io.lacrobate.ia.transcriber.service;

import java.util.List;

public record ChatRequest(
        String model,
        List<Message> messages,
        double temperature
) {}
