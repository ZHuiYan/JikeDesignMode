package com.zhy.jike.designmode.auth14.storage;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
