package com.qa.data;


public class Login {
    private String clientAppId;
    private String clientAppVersion;
    private String encryptKey;
    private String data;



    public Login(String clientAppId, String clientAppVersion, String encryptKey, String data) {
        this.clientAppId = clientAppId;
        this.clientAppVersion = clientAppVersion;
        this.encryptKey = encryptKey;
        this.data = data;
    }

    public String getClientAppId() {
        return clientAppId;
    }

    public void setClientAppId(String clientAppId) {
        this.clientAppId = clientAppId;
    }

    public String getClientAppVersion() {
        return clientAppVersion;
    }

    public void setClientAppVersion(String clientAppVersion) {
        this.clientAppVersion = clientAppVersion;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
