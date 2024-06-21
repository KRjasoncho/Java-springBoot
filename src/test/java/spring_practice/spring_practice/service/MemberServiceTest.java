package spring_practice.spring_practice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_practice.spring_practice.domain.Member;
import spring_practice.spring_practice.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

     MemberService memberService;
     MemoryMemberRepository memberRepository;

     @BeforeEach
     public void beforeEach() {
         memberRepository = new MemoryMemberRepository();
         memberService = new MemberService(memberRepository);
     }

     @AfterEach
     public void afterEach(){
         memberRepository.clearStore();
     }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long savaId = memberService.join(member);


        //then
        Member findMember = memberService.findOne(savaId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//                try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //than
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}