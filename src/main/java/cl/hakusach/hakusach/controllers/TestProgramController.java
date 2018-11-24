package cl.hakusach.hakusach.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.hakusach.hakusach.services.GlotService;
import cl.hakusach.hakusach.exceptions.LanguageNotSupported;
import cl.hakusach.hakusach.models.Languages;
import cl.hakusach.hakusach.requests.TestProgramRequest;
import cl.hakusach.hakusach.requests.GlotApiRequest;
import cl.hakusach.hakusach.requests.GlotApiRequest.FileReference;
import cl.hakusach.hakusach.responses.CheckResult;
import cl.hakusach.hakusach.responses.GlotApiResponse;

import cl.hakusach.hakusach.factory.*;

@RestController
@RequestMapping("/api/v1/test/")
public class TestProgramController{

    @Autowired
    private GlotService service;

    @Autowired
    PipelineFactory factory;

    @PostMapping("program/")
    public GlotApiResponse testProgram(@RequestBody TestProgramRequest request) throws Exception {
        
        List<FileReference> programs = new ArrayList<>();

        Languages lang = null;
        
        if (request.getLang().compareTo(Languages.C_LANG.getLanguage()) == 0) {
            programs.add(FileReference.builder()
                .name("main.c")
                .content(request.getProgram())
                .build()
            );
            lang = Languages.C_LANG;
        }
        else if (request.getLang().compareTo(Languages.JAVA_LANG.getLanguage()) ==0) {
            programs.add(FileReference.builder()
                .name("Main.java")
                .content(request.getProgram())
                .build()
            );
            lang = Languages.JAVA_LANG;
        }
        else if (request.getLang().compareTo(Languages.PYTHON_LANG.getLanguage()) == 0) {           
            programs.add(FileReference.builder()
                .name("main.py")
                .content(request.getProgram())
                .build()
            );
            lang = Languages.PYTHON_LANG;
        }
        else {
            throw new LanguageNotSupported();
        }

        GlotApiRequest req = GlotApiRequest.builder()
                    .stdin(request.getStdin())
                    .files(programs)
                    .build();
        
        return service.sendProgram(req, lang);
    }

    @PostMapping("program/check")
    public Object checkProgram(@RequestBody TestProgramRequest request) throws LanguageNotSupported {

        Pipeline pipeline = factory.createPipeline(request.getLang());

        if (pipeline == null) {
            throw new LanguageNotSupported();
        }

        pipeline.analyze(request.getProgram());

        return CheckResult.builder()
            .comment(pipeline.getCommentsResult())
            .mainComment(pipeline.getMainCommentsResult())
            .naming(pipeline.getVariablesResult())
            .format(pipeline.getIdentationResult())
            .build();
    }

}