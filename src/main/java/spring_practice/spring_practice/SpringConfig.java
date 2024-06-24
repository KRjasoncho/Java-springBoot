package spring_practice.spring_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_practice.spring_practice.repository.MemberRepository;
import spring_practice.spring_practice.repository.MemoryMemberRepository;
import spring_practice.spring_practice.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
