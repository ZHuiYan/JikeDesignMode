package com.zhy.jike.designmode.auth14.authtoken;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1*60*1000;
    private long expired_time_interval = DEFAULT_EXPIRED_TIME_INTERVAL;
    private String token;
    private long createTime;

    public AuthToken(String token,long createTime){
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token,long createTime,long expired_time_interval){
        this.token = token;
        this.createTime = createTime;
        this.expired_time_interval = expired_time_interval;
    }
    public static AuthToken generate(String url, String appId,String password){
        String token = url.substring(0,3);
        return new AuthToken(token,System.currentTimeMillis());
    }

    public String getToken() {
        return token;
    }
    public boolean isExpired(){
        if((System.currentTimeMillis())-this.createTime>expired_time_interval){
            return true;
        }
        return false;
    }

    public boolean match(AuthToken  authToken){
        if(this.token.equals(authToken.token)){
            return true;
        }
        return false;
    }

}
