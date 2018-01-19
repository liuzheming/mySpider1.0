package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import po.JobDesc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/10.
 */
public class JDParser {


    public static List<String> parseUrls(Document doc) {
        Elements divs = doc.getElementById("resultList").children();
        List<String> list = new ArrayList<>();
        for (Element div : divs) {
            if (div.hasClass("el") && !div.hasClass("title")) {
                String subUrl = div.select("p>span>a").attr("href");
                list.add(subUrl);
            }
        }
        return list;
    }

    /**
     * 从html中提取jd信息
     *
     * @param htmlStr jd详情页面
     * @return 封装好的jd对象
     */
    public static JobDesc parseJd(String htmlStr) {

        Document doc = Jsoup.parse(htmlStr);
        JobDesc jd = new JobDesc();
        Elements headDiv = doc.select("div.cn");
        jd.setTitle(headDiv.select("h1").text());
        jd.setLocation(headDiv.select("span.lname").text());
        jd.setSalary(headDiv.select("strong").text());
        jd.setCompanyName(headDiv.select("p.cname>a").text());
        jd.setCompanyType(headDiv.select("p.ltype").text());

        Elements tagSpans = doc.select("div.jtag>div.t1>span.sp4");
        if (tagSpans.select("em.i1").size() > 0)
            jd.setExperience(tagSpans.select("em.i1").text());
        if (tagSpans.select("em.i2").size() > 0)
            jd.setDegree(tagSpans.select("em.i2").text());
        if (tagSpans.select("em.i3").size() > 0)
            jd.setJobNum(tagSpans.select("em.i3").text());
        if (tagSpans.select("em.i4").size() > 0)
            jd.setReleaseTime(tagSpans.select("em.i4").text());
        //    jd.setReleaseTime(tagSpans.get(3).text())

        Elements tags = doc.select("div.jtag>p.t2>span");
        if (tags.size() > 0) {
            for (int i = 1; i < tags.size(); i++) {
                jd.getTags().add(tags.get(i).text());
            }
        }
        jd.setJobMsg(doc.select("div.job_msg").text());
        //    jd.setJobType(doc.select("div.job_msg>span.el").text)
        jd.setJobPosition(doc.select("div.tBorderTop_box>div.bmsg.inbox>p.fp").text());

        jd.setHash1(jd.hashCode());

        // 公司介绍太长了,暂时去掉吧
//        jd.setCompanyMsg(doc.select("div.tmsg.inbox").text());
        return jd;
    }
}
