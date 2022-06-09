package ysh.database.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ysh.database.connection.ConnectionConst;
import ysh.database.repository.MemberRepositoryV1;

import static org.junit.jupiter.api.Assertions.*;
import static ysh.database.connection.ConnectionConst.*;

/**
 * 기본동작, 트랜잭션이 없어서 문제 발생
 */
class MemberServiceV1Test {
    public static final String MEMBER_A = "memberA";
    public static final String MEMBER_B = "memberB";
    public static final String MEMBER_EX = "memberEX";

    private MemberRepositoryV1 memberRepositoryV1;
    private MemberServiceV1 memberServiceV1;

    @BeforeEach
    void before(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        memberRepositoryV1 = new MemberRepositoryV1(dataSource);
        memberServiceV1 = new MemberServiceV1(memberRepositoryV1);
    }

    @Test
    @DisplayName("정상이체")
    void accountTranster(){

    }

}