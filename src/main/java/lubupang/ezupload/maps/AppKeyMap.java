package lubupang.ezupload.maps;

import lubupang.ezupload.objs.AppKeys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppKeyMap {
    @Select("select conf->>'$.endtime' as endtime from conf_temp.appkeys where `name`='${name}'")
    @Results({
            @Result(property = "endtime",column = "endtime")
    })
    AppKeys getKey(String name);

    @Select("select count(*) as c from conf_temp.appkeys where `name`='${name}'")
    @Results({
            @Result(column = "c")
    })
    int getNum(String name);
}
