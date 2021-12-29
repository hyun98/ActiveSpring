package member.membermanage.service;

import member.membermanage.domain.Member;
import member.membermanage.repository.MemberRepository;
import member.membermanage.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 순수 자바 클래스이므로 스프링이 인식하지 못한다. '@Service 를 추가한다.'
public class MemberService {
    private final MemberRepository memberRepository;
    
    // 생성자 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    /*
    * 회원 가입
     */
    public Long join(Member member){
        validateDuplicateMember(member); // 이름 중복 회원 검증
        memberRepository.save(member); 
        return member.getId();
    }
    
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    
    /*
    전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
