package com.zhy.jike.designmode.auth14.storage;

import com.zhy.jike.designmode.auth14.Utils;
import com.zhy.jike.designmode.auth14.storage.CredentialStorage;

/**
 * @author ZHUIyan
 * @date 2020/8/2
 * @github https://github.com/ZHUIyan
 */
public class MysqlCredentialStorage implements CredentialStorage {
    @Override
    public String getPasswordByAppId(String appId) {
        return Utils.user.get(appId);
    }
}
