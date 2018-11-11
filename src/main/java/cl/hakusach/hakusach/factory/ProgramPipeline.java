package cl.hakusach.hakusach.factory;

import cl.hakusach.hakusach.analyzers.Analyzer;

public class ProgramPipeline extends Pipeline {

    public ProgramPipeline(Analyzer commentsAnalyzer, Analyzer variableAnalyzer, Analyzer identationAnalyzer, Analyzer mainCommentsAnalyzer) {

        this.commentsAnalyzer = commentsAnalyzer;
        this.variableAnalyzer = variableAnalyzer;
        this.identationAnalyzer = identationAnalyzer;
        this.mainCommentsAnalyzer = mainCommentsAnalyzer;

    }

}