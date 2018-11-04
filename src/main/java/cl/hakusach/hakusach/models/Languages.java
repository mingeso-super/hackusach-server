package cl.hakusach.hakusach.models;


public enum Languages {

    C_LANG("C", "c/latest"),
    JAVA_LANG("JAVA", "java/latest"),
    PYTHON_LANG("PYTHON", "python/latest");


    private String language;
    private String version;


    private Languages(String language, String version){
        this.language = language;
        this.version = version;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getVersion() {
        return this.version;
    }

}