package es.maneldevs.qa.qacompositeservice.application.model.filter;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScoreFilter {
    private final List<String> targetCodes;
}
