package iuh.fit.springai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat")
    public Map<String, String> generate(@RequestBody ChatRequest request) {
        String response = chatClient.prompt()
                .user(request.message())
                .call()
                .content();

        return Map.of("reply", response == null ? "" : response);
    }

    @GetMapping("/chat")
    public Map<String, String> generate(@RequestParam String message) {
        return generate(new ChatRequest(message));
    }

    public record ChatRequest(String message) {
    }
}