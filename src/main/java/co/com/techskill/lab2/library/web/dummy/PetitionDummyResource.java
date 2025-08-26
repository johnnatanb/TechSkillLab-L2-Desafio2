package co.com.techskill.lab2.library.web.dummy;

import co.com.techskill.lab2.library.service.dummy.PetitionService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/dummy/petitions")
@Profile({"default","dummy"})
public class PetitionDummyResource {

    private final PetitionService petitionService;

    public PetitionDummyResource(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping(value = "/returns/process", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> processReturns() {
        return petitionService.processReturnsFlow();
    }
}
