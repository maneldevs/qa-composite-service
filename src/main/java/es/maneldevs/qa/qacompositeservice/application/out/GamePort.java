package es.maneldevs.qa.qacompositeservice.application.out;

import java.util.List;

import es.maneldevs.qa.qacompositeservice.application.model.dto.ScoreDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.ScoreFilter;

public interface GamePort {
    List<ScoreDto> getQuestionsScore(ScoreFilter filter);
    List<ScoreDto> getAnswersScore(ScoreFilter filter);
}
