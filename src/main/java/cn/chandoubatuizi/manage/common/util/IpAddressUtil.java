package cn.chandoubatuizi.manage.common.util;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableList;

/**
 * IP地址工具类
 */
public class IpAddressUtil {

    /**
     * LOG
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IpAddressUtil.class);

    /**
     * 淘宝IP地址库API<br/>
     * 注意：1.该接口不稳定，且限制qps为1，可能不能获取正确结果 2.该接口通过GET访问时需加上"User-Agent"请求头，否则返回错误信息<br/>
     * TODO 后续考虑换成本地IP库
     */
    private static final String URL = "http://ip.taobao.com/service/getIpInfo.php";

    /**
     * 淘宝IP地址库API返回结果KEY
     */
    private static final ImmutableList<String> TAOBAO_API_KEY = ImmutableList.of("country", "region", "city", "isp");

    /**
     * 通过淘宝IP地址库API查询地址信息
     * 
     * @param ip
     *            IP
     * @return 地址
     */
    public static String getAddressByIP(String ip) {
        String result;
        String address = "未知地址";

        try {
            result = HttpClientUtil.get(URL + "?ip=" + ip, Charset.forName("UTF-8"));
        } catch (Exception e) {
            LOGGER.error("通过淘宝API获取IP实际地址失败", e);
            return address;
        }

        try {
            StringBuilder builder = new StringBuilder();
            JSONObject jsonObject = JSON.parseObject(result);
            JSONObject data = jsonObject.getJSONObject("data");
            for (String key : TAOBAO_API_KEY) {
                String value = data.getString(key);
                if (StringUtils.isNotBlank(value)) {
                    builder.append(value).append("|");
                }
            }
            address = StringUtils.removeEnd(builder.toString(), "|");
        } catch (Exception e) {
            LOGGER.error("转换淘宝result错误", e);
        }
        return address;
    }
}
