package cl.hakusach.hakusach.services;

import java.util.concurrent.CompletableFuture;

import cl.hakusach.hakusach.models.Languages;
import cl.hakusach.hakusach.requests.GlotApiRequest;
import cl.hakusach.hakusach.responses.GlotApiResponse;

public interface DelegateService {

    CompletableFuture<GlotApiResponse> sendProgram(GlotApiRequest request, Languages lang);

}