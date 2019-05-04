package cn.chandoubatuizi.manage.common.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http工具类
 */
public class HttpClientUtil {

    // 连接超时
    private static final int CONNECT_TIMEOUT = 30000;

    // 响应超时
    private static final int SOCKET_TIMEOUT = 30000;

    // 有些请求需要user-agent，如淘宝IP地址查询API如果不加上user-agent则返回错误
    private static final String CHROME_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36";

    /**
     * GET提交
     * 
     * @param url
     *            URL
     * @param charset
     *            字符集
     * @return 响应结果
     * @throws Exception
     *             异常
     */
    public static String get(String url, Charset charset) throws Exception {
        // 创建默认的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("User-Agent", CHROME_USER_AGENT);
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            return EntityUtils.toString(entity, charset);
        } finally {
            IOUtils.closeQuietly(httpResponse);
            IOUtils.closeQuietly(httpClient);
        }
    }

    /**
     * POST提交表单数据
     * 
     * @param url
     *            URL
     * @param params
     *            参数列表
     * @param charset
     *            字符集
     * @return 响应结果
     * @throws Exception
     *             异常
     */
    public static String postForm(String url, Map<String, Object> params, Charset charset) throws Exception {
        // 创建默认的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("User-Agent", CHROME_USER_AGENT);
            List<NameValuePair> pairs = new ArrayList<>();
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                pairs.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, Consts.UTF_8);
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            HttpEntity respEntity = httpResponse.getEntity();
            return EntityUtils.toString(respEntity, charset);
        } finally {
            IOUtils.closeQuietly(httpResponse);
            IOUtils.closeQuietly(httpClient);
        }
    }

    /**
     * POST提交json数据
     * 
     * @param url
     *            URL
     * @param json
     *            json参数字符串
     * @param charset
     *            字符集
     * @return 响应结果
     * @throws Exception
     *             异常
     */
    public static String postJSON(String url, String json, Charset charset) throws Exception {
        // 创建默认的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("User-Agent", CHROME_USER_AGENT);
            StringEntity entity = new StringEntity(json, "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            HttpEntity respEntity = httpResponse.getEntity();
            return EntityUtils.toString(respEntity, charset);
        } finally {
            IOUtils.closeQuietly(httpResponse);
            IOUtils.closeQuietly(httpClient);
        }
    }
}
