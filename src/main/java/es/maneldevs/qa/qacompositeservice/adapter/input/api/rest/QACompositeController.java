package es.maneldevs.qa.qacompositeservice.adapter.input.api.rest;

import org.springframework.web.bind.annotation.RestController;

import es.maneldevs.qa.qacompositeservice.adapter.input.api.QACompositeApi;
import es.maneldevs.qa.qacompositeservice.application.in.QACommandUseCase;
import es.maneldevs.qa.qacompositeservice.application.in.QAQueryUseCase;
import es.maneldevs.qa.qacompositeservice.application.model.command.AnswerCommand;
import es.maneldevs.qa.qacompositeservice.application.model.command.QuestionCommand;
import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QACompositeController implements QACompositeApi {
    private final QAQueryUseCase qaQueryUseCase;
    private final QACommandUseCase qaCommandUseCase;

    @Override
    public QuestionDetailResponse getQuestionDetail(String code) {
        return qaQueryUseCase.getQuestionDetail(code);
    }

    @Override
    public QuestionDetailResponse createQuestion(@Valid QuestionCommand command) {
        return qaCommandUseCase.createQuestion(command);
    }

    @Override
    public QuestionDetailResponse createAnswer(String questionCode, @Valid AnswerCommand command) {
        return qaCommandUseCase.createAnswer(questionCode, command);
    }

    @Override
    public void deleteQuestion(String code) {
        qaCommandUseCase.deleteQuestion(code);
    }
}
