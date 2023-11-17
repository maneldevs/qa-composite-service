package es.maneldevs.qa.qacompositeservice.adapter.output.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import es.maneldevs.libs.exceptionhandling.HttpClientErrorExceptionService;
import es.maneldevs.libs.exceptionhandling.NotFoundException;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDetailDto;
import es.maneldevs.qa.qacompositeservice.application.model.dto.QuestionDto;
import es.maneldevs.qa.qacompositeservice.application.model.filter.QuestionFilter;
import es.maneldevs.qa.qacompositeservice.application.out.QAPort;
import es.maneldevs.qa.qacompositeservice.config.MicroservicesConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class QAHttpClient implements QAPort {
    private final RestTemplate restTemplate;
    private final MicroservicesConfigProperties props;
    private final HttpClientErrorExceptionService errorService;

    @Override
    public List<QuestionDto> getQuestions(QuestionFilter filter) {
        List<QuestionDto> questionsDto = new ArrayList<>();
        String url = props.getQAServiceUrlBase() + "/questions?username=" + filter.getUsername();
        try {
            questionsDto = restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<QuestionDto>>() {})
                .getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value()) {
                throw new NotFoundException(errorService.getErrorMessage(e));
            } else {
                log.warn("Error calling {}", url);
                throw e;
            }
        }
        return questionsDto;
    }

    @Override
    public QuestionDetailDto getQuestion(String code) {
        QuestionDetailDto questionDetailDto = new QuestionDetailDto();
        String url = props.getQAServiceUrlBase() + "/questions/" + code;
        try {
            questionDetailDto = restTemplate
                .exchange(url, HttpMethod.GET, null, QuestionDetailDto.class).getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value()) {
                throw new NotFoundException(errorService.getErrorMessage(e));
            } else {
                log.warn("Error calling {}", url);
                throw e;
            }
        }
        return questionDetailDto;
    }

}
