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

import cl.hakusach.hakusach.models.Languages;

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

        GlotApiResponse response = service.sendProgram(request, Languages.PYTHON_LANG);

        assertEquals("Number from stdin: 42\n", response.getStdout());

    }
    
    @Test
    public void testJava() {

        List<FileReference> programs = new ArrayList<>();
        // Program
        programs.add(FileReference.builder()
            .name("Main.java")
            .content(
            "class Main {\n" 
                + "public static void main(String[] args) {\n"
                + "System.out.println(\"Hello World!\");\n"
                + "}\n"
            +"}\n"
            )
            .build()
        );

        GlotApiRequest request = GlotApiRequest.builder()
            .stdin("")
            .files(programs)
            .build();

        GlotApiResponse response = service.sendProgram(request, Languages.JAVA_LANG);

        assertEquals("Hello World!\n", response.getStdout());

    }

    @Test
    public void testC() {

        List<FileReference> programs = new ArrayList<>();
        // Program
        programs.add(FileReference.builder()
            .name("main.c")
            .content(
                "#include <stdio.h>\n" +
                "int main(void) {\n" +
                    "\tprintf(\"Hello World!\\n\");\n" +
                    "return 0;" +
                "}"
            )
            .build()
        );

        GlotApiRequest request = GlotApiRequest.builder()
            .stdin("")
            .files(programs)
            .build();

        GlotApiResponse response = service.sendProgram(request, Languages.C_LANG);

        assertEquals("Hello World!\n", response.getStdout());

    }

}
