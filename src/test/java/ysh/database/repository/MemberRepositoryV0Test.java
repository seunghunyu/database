package ysh.database.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ysh.database.domain.Member;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class MemberRepositoryV0Test {
    MemberRepositoryV0 repository = new MemberRepositoryV0();
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

    }

}