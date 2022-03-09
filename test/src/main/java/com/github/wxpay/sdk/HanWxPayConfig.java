package com.github.wxpay.sdk;

import java.io.InputStream;

public class HanWxPayConfig  extends WXPayConfig {
    public String getAppID() {
        return "wx4xxxxxxx";
    }

    public String getMchID() {
        return "1589111117";
    }

    public String getKey() {
        return "yDDDsDv6kFG1qXXX6jP";
    }

    public InputStream getCertStream() {
        return null;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }
}