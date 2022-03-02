import java.time.LocalDate;

public class Post {
    private int id;
    private String title;
    private LocalDate create_at;

    public Post(int id, String title, LocalDate create_at) {
        this.id = id;
        this.title = title;
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", create_at=" + create_at +
                '}';
    }
}
