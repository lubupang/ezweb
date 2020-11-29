package lubupang.ezupload.services;

import lubupang.ezupload.maps.SYCMConfMap;
import lubupang.ezupload.objs.SYCMConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SYCMConfService {
    @Autowired
    SYCMConfMap map;
    public SYCMConfService(SYCMConfMap map) {
        this.map = map;
    }
    public SYCMConf get(){
        return map.getSYCMAESConf();
    }

}
