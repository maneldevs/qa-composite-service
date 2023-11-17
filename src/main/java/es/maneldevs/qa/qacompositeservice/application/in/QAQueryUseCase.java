package es.maneldevs.qa.qacompositeservice.application.in;

import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;

public interface QAQueryUseCase {
    QuestionDetailResponse getQuestionDetail(String code);
}
