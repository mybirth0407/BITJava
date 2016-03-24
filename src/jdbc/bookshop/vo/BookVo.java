package jdbc.bookshop.vo;

public class BookVo {
    private Long no;
    private String title;
    private String state;
    private Long AuthorNo;

    private String authorName;

//    private AuthorVo authorVo;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getAuthorNo() {
        return AuthorNo;
    }

    public void setAuthorNo(Long authorNo) {
        AuthorNo = authorNo;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = this.authorName;
    }

    @Override
    public String toString() {
        return "BookVo{" +
            "no=" + no +
            ", title='" + title + '\'' +
            ", state='" + state + '\'' +
            ", AuthorVo=" + AuthorNo +
            ", authorName='" + authorName + '\'' +
            '}';
    }
}
