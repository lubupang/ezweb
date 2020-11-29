package lubupang.ezupload.maps;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HttpDataMap {
    @Insert("insert into syscm_for_y.httpdatas(domain,`path`,filename,queries,cookies,requestbody,response) values ('${domain}','${path}','${filename}','${queries}','${cookies}','${requestbody}','${response}')" )
    void insert(String domain,String path,String filename,String queries,String cookies,String requestbody,String response);

}
