package io.lacrobate.ia.transcriber.transcribe;

import java.util.List;

public record ChatRequest(
        String model,
        List<Message> messages,
        double temperature
) {}
