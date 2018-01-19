package spider;

import conn.HttpConn;
import parser.JDParser;
import po.JobDesc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/2.
 */
public class JobSpider implements Runnable {

    private HttpConn conn = new HttpConn();

    private int count = 0;

    private Collection<Integer> savedJdHash;

    public JobSpider(Collection<Integer> coll) {
        savedJdHash = coll;
    }


//    private synchronized void countIncre() {
//        count++;
//    }

    /**
     * 爬取多个jd,分别加入带jds集合
     *
     * @param urls 多个jd页面的url集合
     * @param jds  jd的集合
     */
    public void crawlJdsList(List<String> urls, List<JobDesc> jds) {
        for (String url : urls) {
            String jdHtml = conn.getHTML(url);
            JobDesc jd = JDParser.parseJd(jdHtml);
            // 判断url的资源是否已经保存在数据库,如果是,则跳过此url
            if (!savedJdHash.contains(jd.getHash1())) {
                jds.add(jd);
                synchronized (this) {
                    count++;
                    if (count % 10 == 0) System.out.println("找到第 [ " + count + " ] 条信息 : ");
                }
            } else {
                synchronized (this) {
                    System.out.println("发现一条已保存的信息 [hash=" + jd.getHash1() + "]");
                }
            }
        }
    }

    /**
     * 爬取多个jd,分别加入带jds集合
     *
     * @param urls 多个jd页面的url集合
     */
    public Collection<JobDesc> crawlJdsList(List<String> urls) {
        List<JobDesc> jds = new ArrayList<>();
        crawlJdsList(urls, jds);
        return jds;
    }


    @Override
    public void run() {
    }

}
