package es.maneldevs.qa.qacompositeservice.application.in.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.maneldevs.qa.qacompositeservice.application.in.QACommandUseCase;
import es.maneldevs.qa.qacompositeservice.application.model.command.AnswerCommand;
import es.maneldevs.qa.qacompositeservice.application.model.command.QuestionCommand;
import es.maneldevs.qa.qacompositeservice.application.model.dto.AnswerDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDetailDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.ScoreDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.UserDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.ScoreFilter;
import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import es.maneldevs.qa.qacompositeservice.application.out.GamePort;
import es.maneldevs.qa.qacompositeservice.application.out.QAPort;
import es.maneldevs.qa.qacompositeservice.application.out.UserPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QACommandService implements QACommandUseCase {
    private final QAPort qaPort;
    private final GamePort gamePort;
    private final UserPort userPort;

    @Override
    public QuestionDetailResponse createQuestion(@Valid QuestionCommand command) {
        QuestionDetailDto questionDetailDto = qaPort.createQuestion(command);
        UserDto userDto = userPort.getUser(questionDetailDto.getUsername());
        ScoreDto questionScoreDto = new ScoreDto(questionDetailDto.getCode(), 0);
        List<ScoreDto> answersScore = new ArrayList<>();
        return new QuestionDetailResponse(questionDetailDto, userDto, questionScoreDto, answersScore);

    }
    @Override
    public QuestionDetailResponse createAnswer(String questionCode, @Valid AnswerCommand command) {
        QuestionDetailDto questionDetailDto = qaPort.createAnswer(questionCode, command);
        UserDto userDto = userPort.getUser(questionDetailDto.getUsername());
        ScoreDto questionScoreDto = gamePort.getQuestionsScore(new ScoreFilter(List.of(questionCode))).get(0);
        List<AnswerDto> answers = questionDetailDto.getAnswers();
        List<String> answersCode = answers.stream().map(a -> a.getCode()).toList();
        List<ScoreDto> answersScore = gamePort.getAnswersScore(new ScoreFilter(answersCode));
        return new QuestionDetailResponse(questionDetailDto, userDto, questionScoreDto, answersScore);
    }
    @Override
    public void deleteQuestion(String code) {
        QuestionDetailDto questionDetailDto = qaPort.getQuestion(code);
        List<String> targetCodes = questionDetailDto.getAnswers().stream().map(AnswerDto::getCode).toList();
        qaPort.deleteQuestion(code);
        gamePort.deleteQuestionScore(code);
        gamePort.deleteAnswersScore(targetCodes);
    }


}
