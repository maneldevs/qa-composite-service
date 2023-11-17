package es.maneldevs.qa.qacompositeservice.application.model.response;

import es.maneldevs.qa.qacompositeservice.application.model.dto.AnswerDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AnswerResponse {
    private final String code;
    private final String username;
    private final String content;
    // private final LocalDateTime createdAt;
    private final Boolean selected;
    private final Integer pointSum;

    public AnswerResponse(AnswerDto dto, Integer pointSum) {
        this.code = dto.getCode();
        this.username = dto.getUsername();
        this.content = dto.getContent();
       //  this.createdAt = dto.getCreatedAt();
        this.selected = dto.getSelected();
        this.pointSum = pointSum;
    }
}
