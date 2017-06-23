package lyr.demo.mybatis.Controller;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by TYZ016 on 2017/4/27.
 */
@Mapper
public interface GoodsMapper {

    @Select("select count(*) from goods")
    int count();
}
