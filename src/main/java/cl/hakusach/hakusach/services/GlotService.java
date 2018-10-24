package cl.hakusach.hakusach.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.hakusach.hakusach.requests.GlotApiRequest;
import cl.hakusach.hakusach.responses.GlotApiResponse;


@Component
public class GlotService {

    private static final String url = "https://run.glot.io/languages/python/latest";
    private static final String token = "Token c35d12e5-039b-4fb6-8562-b21dbca48c24";

    private RestTemplate restTemplate = new RestTemplate();

    public GlotApiResponse sendProgram(GlotApiRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<GlotApiRequest> req = new HttpEntity<GlotApiRequest>(request, headers);

        ResponseEntity<GlotApiResponse> res = restTemplate.exchange(url,HttpMethod.POST, req, GlotApiResponse.class);

        return res.getBody();
    }



}