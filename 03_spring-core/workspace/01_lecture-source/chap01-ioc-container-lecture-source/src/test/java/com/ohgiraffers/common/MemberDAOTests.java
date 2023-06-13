package com.ohgiraffers.common;

import com.ohgiraffers.section03.subsection01.java.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
//이 어노테이션을 통해서 test에서 spring사용하겠다. ContextConfiguration를 사용해서 위치 설정해줌
public class MemberDAOTests
{
    @Autowired//여기다가 bean을 넣어주자 자동으로 같고있는 bean중에 type이 맞는 bean을 연결해줌
    private  MemberDAO memberDAO;


    @Test
    public void testCreateMemberDAO (){
        assertNotNull(memberDAO);
    }
    //memberDAO가 NULL인지 아닌지 확인
    @Test
    public void testFindMemberbySequence(){
        //given

        int sequence =1 ;


        //when
//        MemberDAO memberDAO = new MemberDAO();
//        이런식으로 하지 말고 bean으로 해보자!
        Member foundMember = memberDAO.findMemberBySequence(sequence);
        //then

        assertEquals("홍길동",foundMember.getName());
    }


    @Test
    public void testSave(){
        //given
        Member member = new Member(3,"user03","pass03","유관순");
        //when
        boolean result  = memberDAO.save(member);
        //then
        
        assertTrue(result);
    }
}
