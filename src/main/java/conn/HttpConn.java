package conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/5.
 */
public class HttpConn {

    public String getHTML(String url) {
        URL urlObj;
        StringBuilder strBuilder = null;
        try {
            urlObj = new URL(url);

            URLConnection conn = urlObj.openConnection();
            conn.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "gb2312"));
            strBuilder = new StringBuilder();
            String str = br.readLine();
            while (str != null) {
                strBuilder.append(str);
                //      println(str)
                str = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuilder == null ? "" : strBuilder.toString();
    }


}
