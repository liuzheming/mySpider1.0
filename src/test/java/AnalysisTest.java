import com.hankcs.hanlp.corpus.occurrence.Occurrence;
import com.hankcs.hanlp.corpus.occurrence.TermFrequency;
import dao.JDdao;
import po.JobDesc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/18.
 */
public class AnalysisTest {


    public static void main(String... args) {
        String str = "岗位职责： 1、参与项目需求分析和系统设计 2、完成核心/重要模块的设计、编码、测试以及相关文档 3、能独立解决开发中遇到的难点问题 4、参与系统稳定性、性能和扩展性调试 5、负责公司线上运营系统的产品功能升级工作 任职资格： 1、计算机相关专业本科以上学历，2年以上工作经验。 2、熟悉面向对象的设计和编程，具有扎实的Java基础知识；熟悉B\\S结构开发；熟悉JSTL/EL等JSP的相关知识。 3、熟练掌握SpringMVC，MyBatis，Spring架构，熟悉SSH等企业基本架构。 4、熟悉Mysql数据库开发、可独立撰写复杂的sql语句。 5、熟悉Tomcat应用服务器的部署、了解Linux部署环境。 6、熟悉SVN等版本控制工具，了解Git、Maven，熟练使用Eclipse等开发工具。 7、有一定的js/JQuery的知识，能够解决前端展示异常的情况。 8、能承受较强的工作压力，热爱软件开发技术，积极上进，学习能力强，能够不断学习和自我激励。 9、业务理解力强，数据模型设计功底深厚，能够借助互联网独立解决发开中常见问题。 有下面条件者优先： 1、有良好的代码规范和注释习惯优先。 2、有移动端后台开发经验者优先。 3、有大规模高并发访问的Web应用设计和开发经验优先。 4、有Apache或nginx使用和优化经验优先。 5、有互联网金融经验者优先。 职能类别： 高级软件工程师 分享 微信 邮件";
//        System.out.println(NLPTokenizer.segment(str));


        JDdao dao = new JDdao();

        try {
            List<JobDesc> jds = dao.queryAll();

            StringBuilder builder = new StringBuilder();

            for (JobDesc jd : jds) {
                builder.append(jd.getJobMsg());
            }

            System.out.println(builder.length());
//            List<Term> terms = NLPTokenizer.segment(builder.toString());

//            for (Term term : terms) {
//                System.out.println(term.word);
//            }

//            System.out.println(terms.size());
//            System.out.println(terms.stream().distinct().count());

            Occurrence occurrence = new Occurrence();
            occurrence.addAll(builder.toString());
            occurrence.compute();

            Set<Map.Entry<String, TermFrequency>> uniGram = occurrence.getUniGram();

            List<TermFrequency> list = new ArrayList<>();

            for (Map.Entry<String, TermFrequency> entry : uniGram) {
                TermFrequency termFrequency = entry.getValue();
//                System.out.println(termFrequency);
                list.add(termFrequency);
            }

            list.sort((o1, o2) -> o1.getValue() - o2.getValue());
            for (TermFrequency term : list) {
                System.out.println(term.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
