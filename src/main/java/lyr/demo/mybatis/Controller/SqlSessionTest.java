package lyr.demo.mybatis.Controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by TYZ016 on 2017/4/26.
 */
@Controller
@RequestMapping(value = "/test")
public class SqlSessionTest {
    @Autowired
    SqlSession sqlSession;

    @RequestMapping(method = RequestMethod.GET)
    public int test() {
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        return mapper.count();
    }
}
