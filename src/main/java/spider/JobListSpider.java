package spider;

import conn.HttpConn;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import parser.JDParser;

import java.util.List;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/10.
 */
public class JobListSpider {

    private HttpConn conn = new HttpConn();

    public List<String> crawl(String url) {
        // 获取所有符合条件的详情页的url
        Document doc = getUrlList(url);
        return JDParser.parseUrls(doc);
    }

    /**
     * 查询一个列表页,提取上面详情页链接
     *
     * @param listPageUrl 列表页地址
     */
    private Document getUrlList(String listPageUrl) {
        String htmlStr = conn.getHTML(listPageUrl);
        return Jsoup.parse(htmlStr);
    }

}
