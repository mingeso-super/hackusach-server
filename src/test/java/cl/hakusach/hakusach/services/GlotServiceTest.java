package cl.hakusach.hakusach.services;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.hakusach.hakusach.requests.GlotApiRequest;
import cl.hakusach.hakusach.requests.GlotApiRequest.FileReference;
import cl.hakusach.hakusach.responses.GlotApiResponse;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlotServiceTest {

    private GlotService service = new GlotService();

	@Test
	public void testPython() {

        List<FileReference> programs = new ArrayList<>();
        // Program
        programs.add(FileReference.builder()
            .name("main.py")
            .content("print(input('Number from stdin: '))")
            .build()
        );

        GlotApiRequest request = GlotApiRequest.builder()
            .stdin("42")
            .files(programs)
            .build();

        GlotApiResponse response = service.sendProgram(request);

        assertEquals("Number from stdin: 42\n", response.getStdout());

	}

}
