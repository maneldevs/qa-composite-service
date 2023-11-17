package es.maneldevs.qa.qacompositeservice.application.out;

import java.util.List;

import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDetailDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.QuestionFilter;

public interface QAPort {
    List<QuestionDto> getQuestions(QuestionFilter filter);
    QuestionDetailDto getQuestion(String code);
}
