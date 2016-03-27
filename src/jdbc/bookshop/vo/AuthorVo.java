package jdbc.bookshop.vo;

public class AuthorVo {
    private Long no;
    private String name;
    
    public String getName() {
        return name;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorVo{}";
    }
}
