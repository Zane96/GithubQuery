package com.example.zane.githubquery.model.bean;

import java.io.Serializable;

/**
 * Created by Zane on 16/1/26.
 */
public class Users implements Serializable{
    /**
     * login : Zane96
     * id : 12124524
     * avatar_url : https://avatars.githubusercontent.com/u/12124524?v=3
     * gravatar_id :
     * url : https://api.github.com/users/Zane96
     * html_url : https://github.com/Zane96
     * followers_url : https://api.github.com/users/Zane96/followers
     * following_url : https://api.github.com/users/Zane96/following{/other_user}
     * gists_url : https://api.github.com/users/Zane96/gists{/gist_id}
     * starred_url : https://api.github.com/users/Zane96/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/Zane96/subscriptions
     * organizations_url : https://api.github.com/users/Zane96/orgs
     * repos_url : https://api.github.com/users/Zane96/repos
     * events_url : https://api.github.com/users/Zane96/events{/privacy}
     * received_events_url : https://api.github.com/users/Zane96/received_events
     * type : User
     * site_admin : false
     * name : Zane Xu
     * company : null
     * blog : http://zane96.github.io
     * location : Chonqing China
     * email : wo1996zhi@vip.qq.com
     * hireable : null
     * bio : null
     * public_repos : 24
     * public_gists : 0
     * followers : 17
     * following : 33
     * created_at : 2015-04-26T15:32:19Z
     * updated_at : 2016-01-22T14:53:46Z
     */

    private String login;
    private String avatar_url;
    private String name;
    private Object company;
    private String blog;
    private String location;
    private int public_repos;
    private int followers;
    private int following;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public Object getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getLocation() {
        return location;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }
}
