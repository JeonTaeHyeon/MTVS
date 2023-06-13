package com.ohgiraffers.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//@Component
@Repository
//@Controller 좀더 컨트롤러를 위한 메소드들이 있음
//@Service 서비스는 따로 추가적인 기능이 있지는 않다.
// component와 Repository역할이 같지만 repository가 상속받아서 더 확장된 상태
// Component scan의 탐색범위에 들어오도록 Component annotation을 사용함

public class MemberDAO {


    private final Map<Integer, Member> memberMap;

    public MemberDAO() {
        this.memberMap = new HashMap<>();

        this.memberMap.put(1, new Member(1, "User01", "pass01", "홍길동"));
        this.memberMap.put(2, new Member(2, "User02", "pass02", "유관순"));
    }


    public Member findMemberBySequence(int sequence) {
        return memberMap.get(sequence);
    }

    public boolean save(Member member) {
        int before = memberMap.size();
        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return after > before ? true : false;
    }
}
