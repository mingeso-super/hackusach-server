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

import cl.hakusach.hakusach.models.Profesor;
import cl.hakusach.hakusach.repositories.AlumnoRepository;
import cl.hakusach.hakusach.repositories.ProfesorRepository;
import cl.hakusach.hakusach.security.CustomAuthenticationProvider;
import cl.hakusach.hakusach.security.WebSecurity;

@RunWith(SpringRunner.class)
@WebMvcTest({WebSecurity.class, CustomAuthenticationProvider.class, ProfesorController.class})
public class ProfesorControllerTests {

    Logger log = Logger.getLogger(ProfesorControllerTests.class.toString());

    @Autowired
    private MockMvc mvc;

    static Profesor buffer = null;
    static Gson gson = new Gson();

    @MockBean
    private AlumnoRepository alumnoRepository;

    @MockBean
    private ProfesorRepository repository;

	@Test
	public void fullCrud() throws Exception {

        Profesor profesor = Profesor.builder()
            .username("username")
            .nombres("Profesor")
            .apellidos("De Prueba")
            .password("DUMMY")
            .build();
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/profesores/")
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(gson.toJson(profesor)
                );


        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        log.info("contentString: " + result.getResponse().getContentAsString());
        buffer = gson.fromJson(result.getResponse().getContentAsString(), Profesor.class);

        profesor = Profesor.builder()
            .username("username")
            .nombres("Profesor")
            .apellidos("De Prueba Modificado")
            .password("DUMMY")
            .build();
        
        requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/profesores/" + 1)
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(gson.toJson(profesor)
                );


        result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        buffer = gson.fromJson(result.getResponse().getContentAsString(), Profesor.class);

        profesor = Profesor.builder()
            .username("username")
            .nombres("Profesor")
            .apellidos("De Prueba Modificado")
            .password("DUMMY")
            .build();
        
        requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/profesores/" + 1)
                .accept(MediaType.APPLICATION_JSON);


        result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        buffer = gson.fromJson(result.getResponse().getContentAsString(), Profesor.class);


        
        requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/profesores/" + 1)
                .accept(MediaType.APPLICATION_JSON);


        result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
