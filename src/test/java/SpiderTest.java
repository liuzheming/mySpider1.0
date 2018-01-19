import manager.JobSpiderManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/7.
 */
public class SpiderTest {

    long timeConsume = 0;


    @Before
    public void before() {
        timeConsume = System.currentTimeMillis();
        System.out.println(timeConsume);
    }


    @Test
    public void testJobSpider() throws Exception {
        new JobSpiderManager().crawl("java", "北京");
    }

    @Test
    public void testMutiJobSpider() throws Exception {
        new JobSpiderManager().mutiCrawlByPool("java", "北京");
    }

    @After
    public void after() {
        System.out.println(System.currentTimeMillis() - timeConsume);
    }

}
