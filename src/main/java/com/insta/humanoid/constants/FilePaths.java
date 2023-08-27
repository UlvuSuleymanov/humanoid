package com.insta.humanoid.constants;

public enum FilePaths {
    POPULAR_USERS("src/main/resources/static/TargetPopularProfiles.txt"),
    TARGET_USERS("src/main/resources/static/TargetUsers.txt"),
    IGNORED_USERS("src/main/resources/static/ignoredUsers.txt");


    private String url;

    FilePaths(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
