package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/conferences")
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) { // <1>
        this.conferenceService = conferenceService;
    }

    @Get("/random")
    Conference randomConf() { // <2>
        return conferenceService.randomConf(); // <3>
    }
}
