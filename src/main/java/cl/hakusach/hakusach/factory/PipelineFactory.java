package cl.hakusach.hakusach.factory;

import cl.hakusach.hakusach.models.Languages;
import cl.hakusach.hakusach.analyzers.*;

public class PipelineFactory implements AbstractPipelineFactory {

    @Override
    public Pipeline createPipeline(String pipeline) {

        ProgramPipeline programPipeline = null;

        if(pipeline.compareTo(Languages.C_LANG.getLanguage()) == 0) {

            programPipeline = new ProgramPipeline( 
                new ClangCommentsAnalizer(), 
                new ClangVariableAnalizer(), 
                new ClangIdentationAnalizer(), 
                new ClangMainCommentsAnalizer());
        }
        else if(pipeline.compareTo(Languages.JAVA_LANG.getLanguage()) == 0) {
            programPipeline = new ProgramPipeline(
                new JavaCommentsAnalizer(), 
                new JavaVariableAnalizer(), 
                new JavaIdentationAnalizer(), 
                new JavaMainCommentsAnalizer());

        }
        else if(pipeline.compareTo(Languages.PYTHON_LANG.getLanguage()) == 0) {
            programPipeline = new ProgramPipeline(
                new PythonCommentsAnalizer(), 
                new PythonVariableAnalizer(), 
                new PythonIdentationAnalizer(), 
                new PythonMainCommentsAnalizer());
        }

        return programPipeline;
    }

}