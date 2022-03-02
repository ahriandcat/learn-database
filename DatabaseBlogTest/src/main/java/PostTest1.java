import java.time.LocalDate;

public class PostTest1 extends Post {
    private String description;
    private String thumnail;

    public PostTest1(int id, String title, LocalDate create_at, String description, String thumnail) {
        super(id, title, create_at);
        this.description = description;
        this.thumnail = thumnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    @Override
    public String toString() {
        return super.toString()+
                "description='" + description + '\'' +
                ", thumnail='" + thumnail + '\'' +
                '}';
    }
}
