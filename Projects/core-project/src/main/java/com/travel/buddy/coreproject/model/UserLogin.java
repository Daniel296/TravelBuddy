package com.travel.buddy.coreproject.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN")
public class UserLogin implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4630951279196708431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_LOGIN_ID", unique = true, nullable = false)
    private long userLoginId;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FACEBOOK_TOKEN", nullable = false)
    private String facebookToken;

    @Column(name = "GOOGLE_TOKEN", nullable = false)
    private String googleToken;

    @Column(name ="INTERESTS")
    @OneToMany(mappedBy = "userLogin")
    private List<Interest> interests;

    @OneToOne(mappedBy = "userLogin", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    private UserProfile userProfile;

    public UserLogin(String email, String password, String facebookToken, String googleToken,
        List<Interest> interests, UserProfile userProfile) {
        super();
        this.email = email;
        this.password = password;
        this.facebookToken = facebookToken;
        this.googleToken = googleToken;
        this.interests = interests;
        this.userProfile = userProfile;
    }

    public UserLogin(long userProfileId, String email, String password, String facebookToken, String googleToken,
        List<Interest> interests, UserProfile userProfile) {
        super();
        this.userLoginId = userProfileId;
        this.email = email;
        this.password = password;
        this.facebookToken = facebookToken;
        this.googleToken = googleToken;
        this.interests = interests;
        this.userProfile = userProfile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public void setGoogleToken(String googleToken) {
        this.googleToken = googleToken;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public String getGoogleToken() {
        return googleToken;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }
}
