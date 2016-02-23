package server;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/servers")
    public Server server(@RequestParam(value="name", defaultValue="Jenkins") String name) {
        return new Server(counter.incrementAndGet(), "tucano", "Continuous Integration",
                            String.format(template, name), "ACTIVE");
    }
}
