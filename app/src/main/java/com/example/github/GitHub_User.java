package com.example.github;

public class GitHub_User {
    private String login;
    private String name;
    private int public_repos;
    private int followers;

    // Constructor
    public GitHub_User(String login, String name, int public_repos, int followers) {
        this.login = login;
        this.name = name;
        this.public_repos = public_repos;
        this.followers = followers;
    }

    // Getters
    public String getLogin() { return login; }
    public String getName() { return name; }
    public int getPublic_repos() { return public_repos; }
    public int getFollowers() { return followers; }
}
