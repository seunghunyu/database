package ysh.database.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.PeriodAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ysh.database.domain.Member;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static ysh.database.connection.ConnectionConst.*;

@Slf4j
class MemberRepositoryV1Test {
    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach(){
        //기본 DriverManager - 항상 새로운 커넥션을 획득
        //DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        //커넥션풀링
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repository = new MemberRepositoryV1(dataSource);
    }


    @Test
    void crud() throws SQLException {
        //save
        Member memberV0 = new Member("memberV0", 10000);
        repository.save(memberV0);

        //findById
        Member findMember = repository.findById(memberV0.getMemberId());
        log.info("findMember={}",findMember);
        log.info("member != findMember {}",memberV0 == findMember);
        log.info("member equals findMember {}",memberV0.equals(findMember));
        assertThat(findMember).isEqualTo(memberV0);

        //update: money 10000 -> 20000
        repository.update(memberV0.getMemberId(),20000);
        Member updatedMember = repository.findById(memberV0.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(memberV0.getMemberId());
        assertThatThrownBy(()-> repository.findById(memberV0.getMemberId())).isInstanceOf(NoSuchElementException.class);
    }

}