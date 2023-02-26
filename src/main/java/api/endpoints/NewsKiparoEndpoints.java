package api.endpoints;

import lombok.Getter;

public enum NewsKiparoEndpoints {
    NEWS("it_news");

    @Getter
    private final String endpoint;

    NewsKiparoEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
