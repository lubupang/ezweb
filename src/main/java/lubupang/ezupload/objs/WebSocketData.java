package lubupang.ezupload.objs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;

public class WebSocketData {
    public int id;
    public String domain;
    public String[] path;
    public String filename;
    public JsonNode cookies;
    public String type;
    public JsonNode message;

    @JsonCreator
    public WebSocketData(@JsonProperty("domain") String domain, @JsonProperty("path") String[] pathArr, @JsonProperty("filename") String fileName, @JsonProperty("cookies") JsonNode cookiesArr,@JsonProperty("type") String type,@JsonProperty("message") JsonNode messageJson){
        this.domain=domain;
        this.path=pathArr;
        this.filename=fileName;
        this.cookies=cookiesArr;
        this.type=type;
        this.message=messageJson;
    }
    public WebSocketData(){

    }


}