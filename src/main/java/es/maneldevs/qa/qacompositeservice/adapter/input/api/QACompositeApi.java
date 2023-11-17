package es.maneldevs.qa.qacompositeservice.adapter.input.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.maneldevs.qa.qacompositeservice.application.model.response.QuestionDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "QA Composite")
@RequestMapping("qa-composite")
public interface QACompositeApi {

    @Operation(summary = "Get question details including answers and scores")
    @GetMapping("questions/{code}")
    QuestionDetailResponse getQuestionDetail(@PathVariable String code);
    
}
