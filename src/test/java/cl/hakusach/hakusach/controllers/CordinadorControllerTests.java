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

import cl.hakusach.hakusach.models.Cordinador;
import cl.hakusach.hakusach.repositories.AlumnoRepository;
import cl.hakusach.hakusach.repositories.CordinadorRepository;
import cl.hakusach.hakusach.repositories.ProfesorRepository;
import cl.hakusach.hakusach.security.CustomAuthenticationProvider;
import cl.hakusach.hakusach.security.WebSecurity;

@RunWith(SpringRunner.class)
@WebMvcTest({WebSecurity.class, CustomAuthenticationProvider.class, CordinadorController.class})
public class CordinadorControllerTests {

    Logger log = Logger.getLogger(CordinadorControllerTests.class.toString());

    @Autowired
    private MockMvc mvc;

    static Cordinador buffer = null;
    static Gson gson = new Gson();

    @MockBean
    private AlumnoRepository alumnoRepository;

    @MockBean
    private ProfesorRepository profesorRepository;

    @MockBean
    private CordinadorRepository repository;

	@Test
	public void fullCrud() throws Exception {

        Cordinador profesor = Cordinador.builder()
            .nombres("Cordinador")
            .apellidos("De Prueba")
            .build();
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/cordinadores/")
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(gson.toJson(profesor)
                );


        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        log.info("contentString: " + result.getResponse().getContentAsString());
        buffer = gson.fromJson(result.getResponse().getContentAsString(), Cordinador.class);

        profesor = Cordinador.builder()
            .nombres("Cordinador")
            .apellidos("De Prueba Modificado")
            .build();
        
        requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/cordinadores/" + 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(gson.toJson(profesor)
                );


        result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        buffer = gson.fromJson(result.getResponse().getContentAsString(), Cordinador.class);

        profesor = Cordinador.builder()
            .nombres("Cordinador")
            .apellidos("De Prueba Modificado")
            .build();
        
        requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/cordinadores/" + 1)
                .accept(MediaType.APPLICATION_JSON);


        result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        buffer = gson.fromJson(result.getResponse().getContentAsString(), Cordinador.class);


        
        requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/cordinadores/" + 1)
                .accept(MediaType.APPLICATION_JSON);


        result = mvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
