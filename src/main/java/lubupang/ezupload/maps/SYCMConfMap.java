package lubupang.ezupload.maps;

import lubupang.ezupload.objs.SYCMConf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SYCMConfMap {
    @Select("select conf->>'$.key' as `key`,conf->>'$.iv' as iv from conf_temp.appconfs where `name`='sycmdecodeconf'")
    @Results(
            {
                    @Result(property = "key",column = "key"),
                    @Result(property = "iv",column = "iv")
            }
    )
    SYCMConf getSYCMAESConf();

}
