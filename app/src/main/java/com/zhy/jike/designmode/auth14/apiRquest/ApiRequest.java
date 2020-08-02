package com.zhy.jike.designmode.auth14.apiRquest;

import com.zhy.jike.designmode.auth14.Utils;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
public class ApiRequest {
    private String originalUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl,String token,String appId,long timestamp){
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
        this.originalUrl = baseUrl;
    }

    public static ApiRequest buildFormUrl(String url){
        String token = url.substring(0,3);

        return new ApiRequest(url,token, Utils.appId,System.currentTimeMillis());
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
