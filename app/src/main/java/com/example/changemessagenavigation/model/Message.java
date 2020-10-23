package com.example.changemessagenavigation.model;

import java.io.Serializable;

public class Message implements Serializable {
    private User user;
    private String message;
    private int size;
    private String timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!user.equals(message.user)) return false;
        return timestamp.equals(message.timestamp);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + timestamp.hashCode();
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Message(User user, String message,String timestamp, int size) {
        this.user = user;
        this.message = message;
        this.size = size;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", message='" + message + '\'' +
                ", size=" + size +
                '}';
    }
}
