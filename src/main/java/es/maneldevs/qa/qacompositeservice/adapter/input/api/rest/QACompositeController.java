package es.maneldevs.qa.qacompositeservice.adapter.input.api.rest;

import org.springframework.web.bind.annotation.RestController;

import es.maneldevs.qa.qacompositeservice.adapter.input.api.QACompositeApi;
import es.maneldevs.qa.qacompositeservice.application.in.QAQueryUseCase;
import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QACompositeController implements QACompositeApi {
    private final QAQueryUseCase qaQueryUseCase;

    @Override
    public QuestionDetailResponse getQuestionDetail(String code) {
        return qaQueryUseCase.getQuestionDetail(code);
    }
}
