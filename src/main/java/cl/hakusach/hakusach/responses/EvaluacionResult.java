package cl.hakusach.hakusach.responses;

import java.util.List;

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
    private List<Feedback> commFeedbacks;
    private List<Feedback> namingFeedbacks;
    private List<Feedback> formaFeedbacks;

    private float score;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    @EqualsAndHashCode
    @ToString
    @Data
    public static class Feedback {

        private int line;
        private String type;
        private String message;

    }

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