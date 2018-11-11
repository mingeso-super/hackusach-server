package cl.hakusach.hakusach.factory;

import cl.hakusach.hakusach.models.Languages;

public class PipelineFactory implements AbstractPipelineFactory {

    @Override
    public Pipeline createPipeline(String pipeline) {

        if(pipeline.compareTo(Languages.C_LANG.getLanguage()) == 0) {


        }
        else if(pipeline.compareTo(Languages.JAVA_LANG.getLanguage()) == 0) {


        }
        else if(pipeline.compareTo(Languages.JAVA_LANG.getLanguage()) == 0) {
 
        }

        return null;
    }

}