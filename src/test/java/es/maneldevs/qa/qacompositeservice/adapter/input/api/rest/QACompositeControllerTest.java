package es.maneldevs.qa.qacompositeservice.adapter.input.api.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import es.maneldevs.qa.qacompositeservice.application.in.QACommandUseCase;
import es.maneldevs.qa.qacompositeservice.application.in.QAQueryUseCase;

@WebFluxTest(controllers = QACompositeController.class)
public class QACompositeControllerTest {
    @MockBean
    private QAQueryUseCase qaQueryUseCase;
    @MockBean
    private QACommandUseCase qaCommandUseCase;
    @Autowired
    private WebTestClient webClient;

    @Test
    void createAnswer_validCommand_201AndQuestionDetailResponse() {
        // TODO
    }

    @Test
    void createAnswer_commandWithNoUsername_422() {
        // TODO
    }

    @Test
    void createAnswer_commandWithNoContent_422() {
        // TODO
    }

    @Test
    void createQuestion_validCommand_201AndQuestionDetailResponse() {
        // TODO
    }

    @Test
    void createQuestion_CommandWithNoUsername_422() {
        // TODO
    }

    @Test
    void createQuestion_CommandWithNoTitle_422() {
        // TODO
    }

    @Test
    void deleteQuestion_questionCode_204() {
        // TODO
    }

    @Test
    void getQuestionDetail_existentQuestionCode_200AndQuestionDetailResponse() {
        // TODO
    }

    @Test
    void getQuestionDetail_nonExistentQuestionCode_404() {
        // TODO
    }

}
