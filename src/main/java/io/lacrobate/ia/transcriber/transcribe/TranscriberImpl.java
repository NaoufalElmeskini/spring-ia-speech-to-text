package io.lacrobate.ia.transcriber.transcribe;

import io.lacrobate.ia.transcriber.whisperadapter.WhisperTranscriber;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.lacrobate.ia.transcriber.transcribe.FileUtils.copyToLocalFile;

// https://platform.openai.com/docs/tutorials/meeting-minutes
@Service
@AllArgsConstructor
public class TranscriberImpl implements Transcriber {

	private final WhisperTranscriber whisperTranscriber;
	private final ChatGPT chatGPT = new ChatGPT();

//	public void processMeetingMinutes() {
//		// Transcribe audio, or load transcription if it already exists
//		String transcription = getTranscription("EarningsCall");
//
//		Map<String, String> promptMap = Map.ofEntries(Map.entry("summarize", TutorialPrompts.SUMMARIZE_PROMPT),
//				Map.entry("key_points", TutorialPrompts.KEY_POINTS_PROMPT),
//				Map.entry("action_items", TutorialPrompts.ACTION_ITEMS_PROMPT),
//				Map.entry("sentiment", TutorialPrompts.SENTIMENT_PROMPT));
//
//		// Call GPT-4 to get the responses to each prompt
//		//        long startTime = System.nanoTime();
//		//        ConcurrentMap<String, String> responseMap = promptMap.entrySet().parallelStream()
//		//                .peek(e -> System.out.println("Processing " + e.getKey()))
//		//                .collect(Collectors.toConcurrentMap(
//		//                                Map.Entry::getKey,
//		//                                e -> getResponse(e.getValue(), transcription)
//		//                        )
//		//                );
//		//        long endTime = System.nanoTime();
//		//        System.out.printf("Elapsed time: %.3f seconds%n", (endTime - startTime) / 1e9);
//		//
//		//        responseMap.forEach((name, response) ->
//		//                FileUtils.writeTextToFile(response, name + ".txt"));
//		//        FileUtils.writeWordDocument(responseMap);
//	}
//
//	public String getResponse(String prompt, String transcription) {
//		return chatGPT.getResponseToMessages(ChatGPT.GPT_4, new Message(Role.USER, prompt),
//				new Message(Role.SYSTEM, transcription));
//	}

	@Override
	public String getTranscription(String fileName) {
		Path transcriptionFilePath = Paths.get(FileUtils.OUTPUT_RESOURCES_PATH, fileName + ".txt");
		Path audioFilePath = Paths.get(FileUtils.INPUT_RESOURCES_PATH, fileName + ".wav");

		if (Files.exists(transcriptionFilePath)) {
			try {
				return Files.readString(transcriptionFilePath);
			} catch (IOException e) {
				System.err.println("Error reading transcription file: " + e.getMessage());
			}
		} else {
			return whisperTranscriber.transcribe(audioFilePath.toString());
		}
		return "";
	}

	@Override
	public String getTranscription(MultipartFile multiPartFile){

		return whisperTranscriber.transcribe(
				copyToLocalFile(multiPartFile));

	}
}
