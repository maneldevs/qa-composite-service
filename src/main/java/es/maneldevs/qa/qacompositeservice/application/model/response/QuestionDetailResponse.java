package es.maneldevs.qa.qacompositeservice.application.model.response;

import java.util.List;

import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDetailDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.ScoreDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QuestionDetailResponse {
    private final String code;
    private final String title;
    private final String content;
    //private final LocalDateTime createdAt;
    private final List<String> tags;
    private final Integer pointSum;
    private final UserResponse user;
    private final List<AnswerResponse> answers;

    public QuestionDetailResponse(QuestionDetailDto questionDetaildto, UserDto userDto, ScoreDto questionScoreDto,
            List<ScoreDto> answerScoresDto) {
        this.code = questionDetaildto.getCode();
        this.title = questionDetaildto.getTitle();
        this.content = questionDetaildto.getContent();
        //this.createdAt = questionDetaildto.getCreatedAt();
        this.tags = questionDetaildto.getTags();
        this.pointSum = questionScoreDto.getPointSum();
        this.user = new UserResponse(userDto);
        this.answers = questionDetaildto.getAnswers().stream().map(
            a -> new AnswerResponse(a, findScore(answerScoresDto, a.getCode()))).toList();
    }

    private Integer findScore(List<ScoreDto> answerScoresDto, String targetCode) {
        return answerScoresDto.stream().filter(s -> s.getCode().equals(targetCode)).findFirst().get().getPointSum();
    }
}
