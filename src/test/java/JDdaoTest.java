import dao.JDdao;
import org.junit.Before;
import org.junit.Test;
import po.JobDesc;

import java.sql.SQLException;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/7.
 */
public class JDdaoTest {


    private JDdao dao;

    @Before
    public void init() {
        dao = new JDdao();
    }


    @Test
    public void testQueryAll() {
        try {
            System.out.println(dao.queryAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testUpdate() throws SQLException {
        JobDesc jd = dao.get(1);
        jd.setHash2(String.valueOf(jd.hashCode()) + 1111);
        dao.update(jd);

    }


}
