package es.maneldevs.qa.qacompositeservice.application.out;

import java.util.List;

import es.maneldevs.qa.qacompositeservice.application.model.command.AnswerCommand;
import es.maneldevs.qa.qacompositeservice.application.model.command.QuestionCommand;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDetailDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.QuestionFilter;
import jakarta.validation.Valid;

public interface QAPort {
    List<QuestionDto> getQuestions(QuestionFilter filter);
    QuestionDetailDto getQuestion(String code);
    QuestionDetailDto createQuestion(@Valid QuestionCommand command);
    QuestionDetailDto createAnswer(String questionCode, @Valid AnswerCommand command);
    void deleteQuestion(String code);
}
