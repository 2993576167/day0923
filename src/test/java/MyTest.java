import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.dao.impl.EmpDaoImpl;
import com.csi.domin.Emp;

import java.sql.SQLException;
import java.util.List;

public class MyTest {

    public static void main(String[] args) throws SQLException {

        EmpDaoImpl empDao = new EmpDaoImpl();
        List<Emp> emps =   empDao.selectAll();
        String s = JSON.toJSONString(emps, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.PrettyFormat);
        System.out.println(s);

    }


}
