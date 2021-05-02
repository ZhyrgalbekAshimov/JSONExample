public class MyClass {

    private String body;
    private String title;
    private int userId;
    private int id;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "UserID: " + userId + "\n" +
                "\nID: " + id +"\n" +
                "\nTitle: " + title +"\n" +
                "\nBody: " + body;
    }
}
