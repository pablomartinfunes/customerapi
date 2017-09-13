package api.response;

/**
 * Created by pfunes on 13/09/17.
 */
public class Status {

    private int code;
    private String description;

    public Status(){
        code = 0;
        description = "Not defined";
    }

    public Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
