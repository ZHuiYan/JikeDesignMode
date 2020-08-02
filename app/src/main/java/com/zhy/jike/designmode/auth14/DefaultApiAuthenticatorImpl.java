package com.zhy.jike.designmode.auth14;

import com.zhy.jike.designmode.auth14.apiRquest.ApiRequest;
import com.zhy.jike.designmode.auth14.authtoken.AuthToken;
import com.zhy.jike.designmode.auth14.storage.CredentialStorage;
import com.zhy.jike.designmode.auth14.storage.MysqlCredentialStorage;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
class DefaultApiAuthenticatorImpl implements ApiAuthenticator {
    private CredentialStorage credentialStorage;
    public DefaultApiAuthenticatorImpl(){
        this.credentialStorage = new MysqlCredentialStorage();
    }
    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage){
        this.credentialStorage = credentialStorage;
    }
    @Override
    public void auth(String url) {
        ApiRequest request = ApiRequest.buildFormUrl(url);
        auth(request);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getOriginalUrl();
        AuthToken clientAuthToken = new AuthToken(token,timestamp);
        if(clientAuthToken.isExpired()){
           throw new RuntimeException("time is expired");
        }
        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverToken = AuthToken.generate(originalUrl,appId,password);
        if(!serverToken.match(clientAuthToken)){
            throw new RuntimeException("token is wrong");
        }
        System.out.println("是自己人");
    }
}
