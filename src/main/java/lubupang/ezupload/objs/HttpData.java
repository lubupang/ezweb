package lubupang.ezupload.objs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


public class HttpData {
    public int id;
    public String domain;
    public String[] path;
    public JsonNode queries;
    public String filename;
    public JsonNode cookies;
    public JsonNode requestBody;
    public JsonNode response;
    @JsonCreator
    public HttpData( @JsonProperty("domain") String domain,@JsonProperty("path") String[] pathArr,@JsonProperty("filename") String fileName,@JsonProperty("cookies") JsonNode cookiesArr,@JsonProperty("queries") JsonNode queries,@JsonProperty("response")JsonNode response,@JsonProperty("requestbody") JsonNode requestBody){
        this.domain=domain;
        this.path=pathArr;
        this.filename=fileName;
        this.queries=queries;
        this.cookies=cookiesArr;
        this.requestBody=requestBody;
        this.response=response;
    }
    public HttpData(){

    }


}
