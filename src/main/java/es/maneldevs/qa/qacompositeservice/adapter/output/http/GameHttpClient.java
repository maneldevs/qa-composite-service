package es.maneldevs.qa.qacompositeservice.adapter.output.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import es.maneldevs.qa.qacompositeservice.application.model.dto.ScoreDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.ScoreFilter;
import es.maneldevs.qa.qacompositeservice.application.out.GamePort;
import es.maneldevs.qa.qacompositeservice.config.MicroservicesConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class GameHttpClient implements GamePort {
    private final RestTemplate restTemplate;
    private final MicroservicesConfigProperties props;

    @Override
    public List<ScoreDto> getQuestionsScore(ScoreFilter filter) {
        List<ScoreDto> scoresDto = new ArrayList<>();
        String targetCodesParam = String.join(",", filter.getTargetCodes());
        String url = props.getGameServiceUrlBase() + "/scores/questions?targetCodes=" + targetCodesParam;
        try {
            scoresDto = restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ScoreDto>>() {})
                .getBody();
        } catch (Exception e) {
            scoresDto = filter.getTargetCodes().stream().map(c -> new ScoreDto(c, null)).toList();
            log.warn("Error calling {}", url);
        }
        return scoresDto;
    }

    @Override
    public List<ScoreDto> getAnswersScore(ScoreFilter filter) {
        List<ScoreDto> scoresDto = new ArrayList<>();
        String targetCodesParam = String.join(",", filter.getTargetCodes());
        String url = props.getGameServiceUrlBase() + "/scores/answers?targetCodes=" + targetCodesParam;
        try {
            scoresDto = restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ScoreDto>>() {})
                .getBody();
        } catch (Exception e) {
            scoresDto = filter.getTargetCodes().stream().map(c -> new ScoreDto(c, null)).toList();
            log.warn("Error calling {}", url);
        }
        return scoresDto;
    }

    @Override
    public void deleteQuestionScore(String code) {
        String url = props.getGameServiceUrlBase() + "/questions/" + code;
        try {
            restTemplate.delete(url);
        } catch (Exception e) {
            log.warn("Error calling {}", url);
            throw e;
        }
    }

    @Override
    public void deleteAnswersScore(List<String> targetCodes) {
        String targetCodesParam = String.join(",", targetCodes);
        String url = props.getGameServiceUrlBase() + "/scores/answers?targetCodes=" + targetCodesParam;
        try {
            restTemplate.delete(url);
        } catch (Exception e) {
            log.warn("Error calling {}", url);
            throw e;
        }
    }


}
