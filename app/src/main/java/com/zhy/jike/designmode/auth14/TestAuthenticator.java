package com.zhy.jike.designmode.auth14;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
class TestAuthenticator {
    public static void main(String[] args) {
        ApiAuthenticator authenticator = new DefaultApiAuthenticatorImpl();
        authenticator.auth("http");
    }
}
