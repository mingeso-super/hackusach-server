package cl.hakusach.hakusach.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import cl.hakusach.hakusach.models.Languages;
import cl.hakusach.hakusach.requests.GlotApiRequest;
import cl.hakusach.hakusach.responses.GlotApiResponse;

public class DelegateServiceImpl implements DelegateService {


    private GlotService service = null;
    
    public DelegateServiceImpl(GlotService service) {
        this.service = service;
    }

    @Override
    @Async
    public CompletableFuture<GlotApiResponse> sendProgram(GlotApiRequest request, Languages lang) {

        return CompletableFuture.completedFuture(service.sendProgram(request, lang));
	} 

}