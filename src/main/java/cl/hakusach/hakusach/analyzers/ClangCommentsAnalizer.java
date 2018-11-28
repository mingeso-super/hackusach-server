package cl.hakusach.hakusach.analyzers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static cl.hakusach.hakusach.analyzers.Ctypes.*;

public class ClangCommentsAnalizer implements Analyzer {

    private static String NAME = "(\\w+)(\\d*)";
    private static String SPACE = " ";

    private static String CUSTOM_STRUCT = "("+STRUCT+")" + 
                                          "("+SPACE+"+"+")"+
                                          "("+NAME+")";

    private static String DATA_TYPES = "(" + VOID + "|" + 
                                            INT + "|" + 
                                            LONG +  "|" + 
                                            CHAR + "|" + 
                                            DOUBLE + "|" + 
                                            FLOAT + "|" + 
                                            CUSTOM_STRUCT+ ")";;

    private Pattern pattern = Pattern.compile("");

    @Override
    public List<Result> check(String code) {
        
        List<Result> results = new ArrayList<>();

        return results;
	}

}