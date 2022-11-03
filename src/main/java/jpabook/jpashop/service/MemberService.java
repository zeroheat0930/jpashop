package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //final 걸려있는 필드만 가지고 생성자 주입 해주는 롬복 기능
public class MemberService {


    private final MemberRepository memberRepository;

//    //@Autowired // 생성자 주입 하나일때는 오토와이어드 뺴도됨
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //회원 가입
    @Transactional
    public Long join(Member member){

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }



    //회원 전체 조회
//    @Transactional(readOnly = true) //읽기 전용
    public List<Member> findMembers(){
        return memberRepository.findALl();
    }
//    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }




    /**
     * 회원 수정
     */
        @Transactional
        public void update(Long id, String name) {
            Member member = memberRepository.findOne(id);
            member.setName(name);
        }



 }
