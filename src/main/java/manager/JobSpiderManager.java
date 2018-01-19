package manager;

import dao.JDdao;
import po.JobDesc;
import spider.AsyncJobSpider;
import spider.JobListSpider;
import spider.JobSpider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/8.
 */
public class JobSpiderManager {


    private JDdao dao = new JDdao();


    public void crawl(String keyword, String area) throws Exception {
        List<JobDesc> jds = new ArrayList<>();
        int pageIdx = 0;
        JobSpider jobSpider;
        jobSpider = new JobSpider(dao.getSavedJdHash());
        while (true) {
            List<String> urls = crawlUrls(keyword, area, ++pageIdx);
            if (urls == null || urls.size() == 0) break;
            jobSpider.crawlJdsList(urls, jds);
        }
        int[] arr = dao.saveBatch(jds);
        for (int i : arr) {
            System.out.print(i + "  ");
            if (i % 50 == 0) System.out.println();
        }
    }

    public void mutiCrawlByPool(String keyword, String area) throws Exception {
        dao.truncate();
        ExecutorService service = Executors.newFixedThreadPool(20);
        JobSpider jobSpider = new JobSpider(dao.getSavedJdHash());
        AsyncJobSpider asyncSpider = new AsyncJobSpider(jobSpider, service);
        List<Future<Collection<JobDesc>>> futureList = new ArrayList<>();
        List<List<String>> urlTable = crawlUrls(keyword, area);
        for (List<String> urls : urlTable) {
            if (urls == null || urls.size() == 0) break;
            futureList.add(asyncSpider.crawl(urls));
        }
        for (Future<Collection<JobDesc>> future : futureList) {
            int[] arr = dao.saveBatch((List<JobDesc>) future.get());
            for (int i : arr) {
                System.out.print(i + "  ");
                if (i % 50 == 0) System.out.println();
            }
            System.out.println();
        }
    }

    public void mutiCrawl(String keyword, String area) throws Exception {

        int pageIdx = 0;
        JobSpider spider = new JobSpider(dao.getSavedJdHash());
        while (true) {
            List<String> urls = crawlUrls(keyword, area, ++pageIdx);
            if (urls == null || urls.size() == 0) break;
            Collection<JobDesc> jds = spider.crawlJdsList(urls);
        }

    }


    private List<String> crawlUrls(String keyword, String area, int pageNum) {
        return new JobListSpider().crawl(prepareUrl(keyword, area, pageNum));
    }


    /**
     * 查询所有符合条件的jd详情的url
     *
     * @param keyword 查询关键字
     * @param area    范围
     * @return 二维数组
     */
    private List<List<String>> crawlUrls(String keyword, String area) {
        int pageIdx = 0;
        List<List<String>> urlTable = new ArrayList<>();
        while (true) {
            List<String> urls = crawlUrls(keyword, area, ++pageIdx);
            if (urls == null || urls.size() == 0) break;
            urlTable.add(urls);
        }
        return urlTable;
    }

    /**
     * 查询所有符合条件的jd详情的url
     *
     * @param keyword 查询关键字
     * @param area    范围
     * @return 二维数组
     */
    private List<List<String>> mutiCrawlUrls(String keyword, String area) {
        int pageIdx = 0;
        List<List<String>> urlTable = new ArrayList<>();
        while (true) {
            List<String> urls = crawlUrls(keyword, area, ++pageIdx);
            if (urls == null || urls.size() == 0) break;
            urlTable.add(urls);
        }
        return urlTable;
    }

    private String prepareUrl(String keyword, String areaname, int pageNum) {
        String str1 = "http://search.51job.com/list/" + getAreaCode(areaname)
                + ",000000,0000,00,9,08," + keyword + ",2,";
        String str2 = ".html?" +
                "lang=c" +
                "&stype=1" +
                "&postchannel=0000" +
                "&workyear=99" +
                "&cotype=99" +
                "&degreefrom=99" +
                "&jobterm=99" +
                "&companysize=99" +
                "&lonlat=0%2C0" +
                "&radius=-1" +
                "&ord_field=0" +
                "&confirmdate=9" +
                "&fromType=21" +
                "&dibiaoid=0" +
                "&address=" +
                "&line=" +
                "&specialarea=00" +
                "&from=" +
                "&welfare=";
        return str1 + pageNum + str2;
    }

    /**
     * 获取地区名称对应的编码
     *
     * @param areaname 地名
     * @return 地名代码
     */
    private String getAreaCode(String areaname) {
        String code = null;
        switch (areaname) {
            case "北京":
                code = "010000";
                break;
            case "成都":
                code = "090200";
            default:
        }
        return code;
    }
}
