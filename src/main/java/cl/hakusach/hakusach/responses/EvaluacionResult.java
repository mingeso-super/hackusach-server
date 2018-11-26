package cl.hakusach.hakusach.responses;

import java.util.List;

import cl.hakusach.hakusach.analyzers.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
@Data
public class EvaluacionResult {

    private List<TestResult> results;
    private List<Result> comments;
    private List<Result> variables;
    private List<Result> identation;
    private List<Result> mainComments;

    private float score;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    @EqualsAndHashCode
    @ToString
    @Data
    public static class TestResult {
        private String input;
        private String output;
        private String expected;
        private boolean passed;
    }

}