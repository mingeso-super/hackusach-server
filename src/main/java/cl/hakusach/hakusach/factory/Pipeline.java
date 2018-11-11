package cl.hakusach.hakusach.factory;

import java.util.List;

import cl.hakusach.hakusach.analyzers.Analyzer;
import cl.hakusach.hakusach.analyzers.Result;

public abstract class Pipeline {

    protected Analyzer commentsAnalyzer;

    protected List<Result> commentsResult;
    
    protected Analyzer variableAnalyzer;

    protected List<Result> variablesResult;
    
    protected Analyzer identationAnalyzer;

    protected List<Result> identationResult;
    
    protected Analyzer mainCommentsAnalyzer;

    protected List<Result> mainCommentsResult;

    public void analyze(String code) {
        this.commentsResult = commentsAnalyzer.check(code);
        this.variablesResult = variableAnalyzer.check(code);
        this.identationResult = identationAnalyzer.check(code);
        this.mainCommentsResult = mainCommentsAnalyzer.check(code);
    }

    public List<Result> getCommentsResult() {
        return commentsResult;
    }

    public List<Result> getIdentationResult() {
        return identationResult;
    }

    public List<Result> getMainCommentsResult() {
        return mainCommentsResult;
    }

    public List<Result> getVariablesResult() {
        return variablesResult;
    }

}