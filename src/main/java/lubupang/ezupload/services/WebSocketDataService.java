package lubupang.ezupload.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lubupang.ezupload.maps.WebSocketDataMap;

import lubupang.ezupload.objs.WebSocketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketDataService {
    @Autowired
    WebSocketDataMap map;
    public WebSocketDataService(WebSocketDataMap map){
        this.map=map;
    }
    public void insert(WebSocketData data) throws JsonProcessingException {
        map.insert(data.domain,new ObjectMapper().writeValueAsString(data.path),data.filename,new ObjectMapper().writeValueAsString(data.cookies),data.type,new ObjectMapper().writeValueAsString(data.message));
    }
}
