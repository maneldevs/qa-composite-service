package es.maneldevs.qa.qacompositeservice.application.in.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.maneldevs.qa.qacompositeservice.application.in.QAQueryUseCase;
import es.maneldevs.qa.qacompositeservice.application.model.dto.AnswerDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDetailDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.ScoreDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.UserDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.ScoreFilter;
import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import es.maneldevs.qa.qacompositeservice.application.out.GamePort;
import es.maneldevs.qa.qacompositeservice.application.out.QAPort;
import es.maneldevs.qa.qacompositeservice.application.out.UserPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QAQueryService implements QAQueryUseCase {
    private final QAPort qaPort;
    private final GamePort gamePort;
    private final UserPort userPort;

    @Override
    public QuestionDetailResponse getQuestionDetail(String code) {
        QuestionDetailDto questionDetailDto = qaPort.getQuestion(code);
        UserDto userDto = userPort.getUser(questionDetailDto.getUsername());
        ScoreDto questionScoreDto = gamePort.getQuestionsScore(new ScoreFilter(List.of(code))).get(0);
        List<AnswerDto> answers = questionDetailDto.getAnswers();
        List<String> answersCode = answers.stream().map(a -> a.getCode()).toList();
        List<ScoreDto> answersScore = gamePort.getAnswersScore(new ScoreFilter(answersCode));
        return new QuestionDetailResponse(questionDetailDto, userDto, questionScoreDto, answersScore);
    }

}
