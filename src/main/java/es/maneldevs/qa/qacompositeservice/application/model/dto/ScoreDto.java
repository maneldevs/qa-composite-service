package es.maneldevs.qa.qacompositeservice.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {
    private String code;
    private Integer pointSum;
}
