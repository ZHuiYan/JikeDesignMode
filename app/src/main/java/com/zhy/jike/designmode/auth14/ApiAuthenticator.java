package com.zhy.jike.designmode.auth14;

import com.zhy.jike.designmode.auth14.apiRquest.ApiRequest;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
public interface ApiAuthenticator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
