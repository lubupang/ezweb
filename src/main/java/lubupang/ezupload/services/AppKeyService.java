package lubupang.ezupload.services;

import lubupang.ezupload.maps.AppKeyMap;
import lubupang.ezupload.objs.AppKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppKeyService {
    @Autowired
    AppKeyMap map;
    public AppKeyService(AppKeyMap map){
        this.map=map;
    }
    public AppKeys get(String name){
        int k=map.getNum(name);
        if(k==0){
            return null;
        }else {
            return map.getKey(name);
        }
    }
}
