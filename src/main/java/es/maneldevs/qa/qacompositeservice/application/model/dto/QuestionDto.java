package es.maneldevs.qa.qacompositeservice.application.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String code;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<String> tags = new ArrayList<>();
}
