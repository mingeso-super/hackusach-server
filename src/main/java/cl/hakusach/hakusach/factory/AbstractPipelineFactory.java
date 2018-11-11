package cl.hakusach.hakusach.factory;

import cl.hakusach.hakusach.factory.Pipeline;

public interface AbstractPipelineFactory {

    public Pipeline createPipeline(String pipeline);


}