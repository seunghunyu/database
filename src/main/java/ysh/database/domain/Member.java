package ysh.database.domain;

import lombok.Data;

@Data
public class Member {
    private String memberId;
    private int money;
    public Member(){}

    public Member(String memberId, int money){
        this.memberId = memberId;
        this.money = money;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
