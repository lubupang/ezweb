package lubupang.ezupload.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FullDecodeJson {
    public static JsonNode parse(JsonNode json) throws JsonProcessingException {
        if(!json.isContainerNode()){
            if(json==null){return null;}
            JsonNode t=null;
            try {
                t=new ObjectMapper().readTree(json.asText());
            }catch (JsonProcessingException e){}
            if(t==null){return json;}


            if(json.asText().equals(t.asText())){return json;}else {
                return parse(t);
            }

        }else {
            if(json.isArray()){
                ArrayList<JsonNode> nodes=new ArrayList<>();
                Iterator<JsonNode> it = json.iterator();
                while (it.hasNext())
                {
                    nodes.add( parse(it.next()));

                }
                return new ObjectMapper().readTree( new ObjectMapper().writeValueAsString( nodes.toArray(new JsonNode[nodes.size()]) ));

            }else{
                HashMap<String,JsonNode> res=new HashMap<>();

                Iterator<Map.Entry<String, JsonNode>> it = json.fields();
                while (it.hasNext())
                {
                    Map.Entry<String, JsonNode> entry = it.next();
                    res.put(entry.getKey(),parse(entry.getValue()));
                }
                return new ObjectMapper().readTree( new ObjectMapper().writeValueAsString( res)) ;
            }


        }







    }
}
