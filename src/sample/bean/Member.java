package sample.bean;

/**
 * Created by Paul on 10/4/17.
 */
public class Member {

    private String memberId;
    private String memberName;
    private String gender;
    private String email;
    private String phone;
    private int userId;

    public Member() {
    }

    public Member(String memberId, String memberName, String gender, String email, String phone) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
