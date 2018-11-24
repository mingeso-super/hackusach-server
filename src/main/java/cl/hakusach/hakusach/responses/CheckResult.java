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
public class CheckResult {

    private List<Result> comment;
    private List<Result> naming;
    private List<Result> format;
    private List<Result> mainComment;

}