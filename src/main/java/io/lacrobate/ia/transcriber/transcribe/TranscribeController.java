package io.lacrobate.ia.transcriber.transcribe;

import io.lacrobate.ia.transcriber.service.WhisperTutorial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TranscribeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TranscribeController.class);
	@Autowired
	private WhisperTutorial whisperTutorial;

	@GetMapping("/{fileName}")
	public String transcribe(@PathVariable("fileName") String fileName){
		LOGGER.info("transcribing {}", fileName);
		return whisperTutorial.getTranscription(fileName);
	}
}
