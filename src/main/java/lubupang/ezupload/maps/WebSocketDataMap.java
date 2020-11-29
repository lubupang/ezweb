package lubupang.ezupload.maps;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebSocketDataMap {
    @Insert("insert into syscm_for_y.websocketdatas(domain,`path`,filename,cookies,type,message) values ('${domain}','${path}','${filename}','${cookies}','${type}','${message}')" )
    void insert(String domain,String path,String filename,String cookies,String type,String message);

}
