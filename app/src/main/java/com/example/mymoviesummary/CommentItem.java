package com.example.mymoviesummary;

public class CommentItem {

    String name;
    String writes;

    public CommentItem(String name, String writes) {
        this.name = name;
        this.writes = writes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWrites() {
        return writes;
    }

    public void setWrites(String writes) {
        this.writes = writes;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "name='" + name + '\'' +
                ", writes='" + writes + '\'' +
                '}';
    }
}
