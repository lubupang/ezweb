package lubupang.ezupload.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lubupang.ezupload.maps.HttpDataMap;
import lubupang.ezupload.objs.HttpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpDataService {
    @Autowired
    HttpDataMap map;
    public HttpDataService(HttpDataMap map){
        this.map=map;
    }
    public void insert(HttpData data) throws JsonProcessingException {
        map.insert(data.domain,new ObjectMapper().writeValueAsString(data.path),data.filename,new ObjectMapper().writeValueAsString(data.queries),new ObjectMapper().writeValueAsString(data.cookies),new ObjectMapper().writeValueAsString(data.requestBody),new ObjectMapper().writeValueAsString(data.response));
    }
}
