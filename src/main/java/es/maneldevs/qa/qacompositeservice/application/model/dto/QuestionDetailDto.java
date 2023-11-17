package es.maneldevs.qa.qacompositeservice.application.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionDetailDto extends QuestionDto {
    private List<AnswerDto> answers = new ArrayList<>();

    public QuestionDetailDto(String code, String username, String title, String content, LocalDateTime createdAt,
            List<String> tags, List<AnswerDto> answers) {
        super(code, username, title, content, createdAt, tags);
        this.answers = answers;
    }
}
