package nl.jdriven.myapplication.in.rest.participants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.jdriven.myapplication.core.SubmissionService;
import nl.jdriven.myapplication.core.model.AnswerRequest;
import nl.jdriven.myapplication.core.model.SubmissionRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
class RoundController {

    private final SubmissionService submissionService;

    @PostMapping(path = "/api/question/{id}")
    public void sendInRound(@PathVariable String id, @RequestBody SubmissionRequest submissionRequest) {
        log.info("SubmissionRequest = {}", submissionRequest);


        submissionService.submit(id, submissionRequest.getUsername(), submissionRequest.getAnswer());


    }


}
