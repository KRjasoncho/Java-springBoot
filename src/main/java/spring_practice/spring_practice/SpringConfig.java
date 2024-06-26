package spring_practice.spring_practice;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_practice.spring_practice.aop.TimeTraceAop;
import spring_practice.spring_practice.repository.JdbcMemberRepository;
import spring_practice.spring_practice.repository.JpaMemberRepository;
import spring_practice.spring_practice.repository.MemberRepository;
import spring_practice.spring_practice.repository.MemoryMemberRepository;
import spring_practice.spring_practice.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
//    @Bean
//    public MemberRepository memberRepository(){
//
//        //return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
}
