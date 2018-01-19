package spider;

import po.JobDesc;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/10.
 */
public class AsyncJobSpider {

    private ExecutorService executorService;
    private JobSpider spider;

    public AsyncJobSpider(JobSpider spider, ExecutorService service) {
        this.executorService = service;
        this.spider = spider;
    }

    public Future<Collection<JobDesc>> crawl(List<String> urls) {
        return executorService.submit(() -> spider.crawlJdsList(urls));
    }

}

