package capstone.JejuTourRecommend.repository;

import capstone.JejuTourRecommend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    Optional<Member> findOptionByEmail(String email); //단건 Optional

}























































