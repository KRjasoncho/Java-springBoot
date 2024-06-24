package spring_practice.spring_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_practice.spring_practice.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
