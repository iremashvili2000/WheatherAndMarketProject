package com.example.demo.models.requests;

import javax.validation.constraints.NotNull;

public class SendEmail {
    @NotNull
    private String to;
    @NotNull
    private String body;
    @NotNull
    private String topic;

    public SendEmail(@NotNull String to, @NotNull String body, @NotNull String topic) {
        this.to = to;
        this.body = body;
        this.topic = topic;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
