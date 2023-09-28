package com.insta.humanoid.constants;

public enum FilePaths {
    POPULAR_USERS("src/main/resources/static/TargetPopularProfiles.txt"),
    TARGET_USERS("src/main/resources/static/TargetUsers.txt"),
    TARGET_POSTS("src/main/resources/static/TargetPosts.txt"),
    TARGET_COMMENTS("src/main/resources/static/TargetComments.txt"),
    IGNORED_USERS("src/main/resources/static/ignoredUsers.txt");


    private String url;

    FilePaths(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
