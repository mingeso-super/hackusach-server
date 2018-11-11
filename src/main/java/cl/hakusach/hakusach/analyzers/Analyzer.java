package cl.hakusach.hakusach.analyzers;

import java.util.List;

public interface Analyzer {

    public List<Result> check(String code);

}