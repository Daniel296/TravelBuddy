package com.travel.buddy.coreproject.DTOs;

public class UserLoginDTO {
    private String email;
    private String password;
    private String facebookToken;
    private String googleToken;
    private String authorizationMethod;
    private String sessionUUID;

    public UserLoginDTO(String email, String password, String facebookToken, String googleToken, String authorizationMethod, String sessionUUID) {
        this.email = email;
        this.password = password;
        this.facebookToken = facebookToken;
        this.googleToken = googleToken;
        this.authorizationMethod = authorizationMethod;
        this.sessionUUID = sessionUUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public String getGoogleToken() {
        return googleToken;
    }

    public void setGoogleToken(String googleToken) {
        this.googleToken = googleToken;
    }

    public String getAuthorizationMethod() {
        return authorizationMethod;
    }

    public void setAuthorizationMethod(String authorizationMethod) {
        this.authorizationMethod = authorizationMethod;
    }

    public String getSessionUUID() {
        return sessionUUID;
    }

    public void setSessionUUID(String sessionUUID) {
        this.sessionUUID = sessionUUID;
    }
}
