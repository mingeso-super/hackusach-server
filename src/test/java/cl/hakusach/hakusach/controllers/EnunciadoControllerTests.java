package cl.hakusach.hakusach.controllers;

import java.util.logging.Logger;

import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

import cl.hakusach.hakusach.models.Enunciado;
import cl.hakusach.hakusach.repositories.EnunciadoRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(EnunciadoController.class)
public class EnunciadoControllerTests {

    Logger log = Logger.getLogger(EnunciadoControllerTests.class.toString());

    @Autowired
    private MockMvc mvc;

    static Enunciado buffer = null;
    static Gson gson = new Gson();
    static final String endpoint = "/api/v1/enunciados/";

    @MockBean
    private EnunciadoRepository repository;

	@Test
	public void fullCrud() throws Exception {

        Enunciado enunciado = Enunciado.builder()
            .enunciado("Test este es un problema de tests")
            .build();
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(endpoint)
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(gson.toJson(enunciado)
                );


        MvcResult result = mvc.perform(requestBuilder).andReturn();
        //assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        log.info("contentString: " + result.getResponse().getContentAsString());
        buffer = gson.fromJson(result.getResponse().getContentAsString(), Enunciado.class);

        enunciado = Enunciado.builder()
            .enunciado("Enunciado Modificado")
            .build();
        
        requestBuilder = MockMvcRequestBuilders
                .put(endpoint + 1)
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(gson.toJson(enunciado)
                );


        result = mvc.perform(requestBuilder).andReturn();
        //assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        buffer = gson.fromJson(result.getResponse().getContentAsString(), Enunciado.class);

        enunciado = Enunciado.builder()
            .enunciado("Enunciado Modificado")
            .build();
        
        requestBuilder = MockMvcRequestBuilders
                .get(endpoint + 1)
                .accept(MediaType.APPLICATION_JSON);


        result = mvc.perform(requestBuilder).andReturn();
        //assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        buffer = gson.fromJson(result.getResponse().getContentAsString(), Enunciado.class);


        
        requestBuilder = MockMvcRequestBuilders
                .delete(endpoint + 1)
                .accept(MediaType.APPLICATION_JSON);


        result = mvc.perform(requestBuilder).andReturn();
        //assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
