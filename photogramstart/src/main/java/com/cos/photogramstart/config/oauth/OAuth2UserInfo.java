package com.cos.photogramstart.config.oauth;

public interface OAuth2UserInfo {
    String getProvider();
    String getUsername();
    String getPassword();
    String getEmail();
    String getName();
}
