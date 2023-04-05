package ysh.database.repository;

import ysh.database.domain.Member;

import java.sql.SQLException;

public interface MemberRepositoryEx {
    Member save(Member member);
    Member findById(String memberId);
    void update(String memberId, int money) throws SQLException;
    void delete(String memberId) throws SQLException;

}
