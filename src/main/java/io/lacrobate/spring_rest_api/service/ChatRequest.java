package io.lacrobate.spring_rest_api.service;

import java.util.List;

public record ChatRequest(
        String model,
        List<Message> messages,
        double temperature
) {}
