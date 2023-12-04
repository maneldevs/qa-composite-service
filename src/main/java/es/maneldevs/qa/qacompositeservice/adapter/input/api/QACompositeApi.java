package es.maneldevs.qa.qacompositeservice.adapter.input.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.maneldevs.qa.qacompositeservice.application.model.command.AnswerCommand;
import es.maneldevs.qa.qacompositeservice.application.model.command.QuestionCommand;
import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "QA Composite")
@RequestMapping("qa-composite")
public interface QACompositeApi {

    @Operation(summary = "Get question details including answers and scores")
    @GetMapping("questions/{code}")
    QuestionDetailResponse getQuestionDetail(@PathVariable String code);

    @Operation(summary = "Create a question")
    @PostMapping("questions")
    @ResponseStatus(HttpStatus.CREATED)
    QuestionDetailResponse createQuestion(@Valid @RequestBody QuestionCommand command);

    @PostMapping("questions/{questionCode}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    QuestionDetailResponse createAnswer(@PathVariable String questionCode, @Valid @RequestBody AnswerCommand command);

    @DeleteMapping("questions/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteQuestion(@PathVariable String code);
    
}
