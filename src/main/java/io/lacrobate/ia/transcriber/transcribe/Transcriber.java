package io.lacrobate.ia.transcriber.transcribe;

import org.springframework.web.multipart.MultipartFile;

public interface Transcriber {
//	@SuppressWarnings("SameParameterValue")
	String getTranscription(String fileName);

	String getTranscription(MultipartFile multiPartFile);
}
