package models;

import models.Post;

import java.time.LocalDate;

public class PostTest2 extends Post {
    private String content;
    private String name;
    private String tag_info;

    public PostTest2(int id, String title, LocalDate create_at, String content, String name, String tag_info) {
        super(id, title, create_at);
        this.content = content;
        this.name = name;
        this.tag_info = tag_info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag_info() {
        return tag_info;
    }

    public void setTag_info(String tag_info) {
        this.tag_info = tag_info;
    }

    @Override
    public String toString() {
        return super.toString()+
                "content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", tag_info=" + tag_info +
                '}';
    }
}
