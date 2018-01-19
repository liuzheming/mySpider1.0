package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import po.JobDesc;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/5.
 */
public class JDdao extends BaseDao {


    public int save(JobDesc jd) {

        String sql = "INSERT INTO job_desc " +
                "( title_, location, salary, companyName, companyType, " +
                "experience, degree, jobNum, releaseTime, jobMsg, " +
                "jobType, jobPosition, part, companyMsg )" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
        int x = 0;
        try {
            x = qr.execute(getConn(), sql,
                    jd.getTitle(), jd.getLocation(), jd.getSalary(), jd.getCompanyName(), jd.getCompanyType(),
                    jd.getExperience(), jd.getDegree(), jd.getJobNum(), jd.getReleaseTime(), jd.getJobMsg(),
                    jd.getJobType(), jd.getJobPosition(), jd.getPart(), jd.getCompanyMsg(), jd.getHash1(), jd.getHash2());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }


    public int[] saveBatch(List<JobDesc> list) throws SQLException {
        String sql = "INSERT INTO job_desc " +
                "( title_, location, salary, companyName, companyType, " +
                "experience, degree, jobNum, releaseTime, jobMsg, " +
                "jobType, jobPosition, part, companyMsg,hash1,hash2 )" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
        Object[][] params = new Object[list.size()][16];
        int i = 0;
        for (JobDesc jd : list) {
            params[i][0] = jd.getTitle();
            params[i][1] = jd.getLocation();
            params[i][2] = jd.getSalary();
            params[i][3] = jd.getCompanyName();
            params[i][4] = jd.getCompanyType();
            params[i][5] = jd.getExperience();
            params[i][6] = jd.getDegree();
            params[i][7] = jd.getJobNum();
            params[i][8] = jd.getReleaseTime();
            params[i][9] = jd.getJobMsg();
            params[i][10] = jd.getJobType();
            params[i][11] = jd.getJobPosition();
            params[i][12] = jd.getPart();
            params[i][13] = jd.getCompanyMsg();
            params[i][14] = jd.getHash1();
            params[i][15] = jd.getHash2();
            i++;
        }
        return qr.batch(getConn(), sql, params);
    }


    public List<JobDesc> queryAll() throws SQLException {
        return new QueryRunner().query(
                getConn(),
                "SELECT * FROM job_desc",
                new BeanListHandler<JobDesc>(JobDesc.class));
    }


    public JobDesc get(int id) throws SQLException {
        return qr.query(
                getConn(),
                "SELECT * FROM job_desc WHERE id_ = ?",
                new BeanHandler<>(JobDesc.class), id);

    }


    public int update(JobDesc jd) throws SQLException {
        String sql = "UPDATE job_desc SET " +
                "title_ = ?, location = ?, salary = ?, companyName = ?, companyType = ?, " +
                "experience = ?, degree = ?, jobNum = ?, releaseTime = ?, jobMsg = ?, " +
                "jobType = ?, jobPosition = ?, part = ?, companyMsg = ?,hash1 = ? , hash2 = ? WHERE id_ = ?";
        return qr.update(getConn(), sql, jd.getTitle(), jd.getLocation(), jd.getSalary(), jd.getCompanyName(), jd
                        .getCompanyType(),
                jd.getExperience(), jd.getDegree(), jd.getJobNum(), jd.getReleaseTime(), jd.getJobMsg(),
                jd.getJobType(), jd.getJobPosition(), jd.getPart(), jd.getCompanyMsg()
                , jd.getHash1(), jd.getHash2(), jd.getId_());

    }

    public Collection<Integer> getSavedJdHash() throws SQLException {
        String sql = "SELECT hash1 FROM job_desc";
        return qr.query(getConn(), sql, new ColumnListHandler<Integer>(1));
    }

    public int truncate() throws SQLException {
        String sql = "TRUNCATE job_desc";
        return qr.execute(sql);
    }

}
