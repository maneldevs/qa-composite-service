package es.maneldevs.qa.qacompositeservice.application.in;

import es.maneldevs.qa.qacompositeservice.application.model.command.AnswerCommand;
import es.maneldevs.qa.qacompositeservice.application.model.command.QuestionCommand;
import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import jakarta.validation.Valid;

public interface QACommandUseCase {
    QuestionDetailResponse createQuestion(@Valid QuestionCommand command);
    QuestionDetailResponse createAnswer(String questionCode, @Valid AnswerCommand command);
    void deleteQuestion(String code);
}
