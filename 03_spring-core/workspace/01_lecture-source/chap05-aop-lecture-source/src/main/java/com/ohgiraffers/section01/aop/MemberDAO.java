package com.ohgiraffers.section01.aop;

import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAO {
    private final Map<Long, Member> memberMap;

    public MemberDAO(){
        this.memberMap=new HashMap<>();

        memberMap.put(1L,new Member(1L,"유관순"));
        memberMap.put(2L,new Member(2L,"홍길동"));
    }

    public List<Member> findAllMember(){
        return new ArrayList<>(memberMap.values());
    }

    public Member findMemberById(Long id){
        Member foundMember=memberMap.get(id);

        if(foundMember== null){
            throw new IllegalStateException("해당하는 id의 회원이 없습니다.");
        }

        return foundMember;
    }

}
