package es.maneldevs.qa.qacompositeservice.application.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private String code;
    private String username;
    private String content;
    private LocalDateTime createdAt;
    private Boolean selected;
}
