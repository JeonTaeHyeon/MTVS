package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO){
        this.memberDAO=memberDAO;
    }

    public List<MemberInfoResponseDTO> findAllMembers(){
        List<Member> members=memberDAO.findAllMember();
        List<MemberInfoResponseDTO> memberDTOs = new ArrayList<>();

        for (Member member : members){
            MemberInfoResponseDTO dto=changeToDTO(member);
            memberDTOs.add((changeToDTO(member)));
        }

        System.out.println("findAllmembers Service method call...");
        return memberDTOs;
    }
    // a return해주는 애는 memberDAO로 바꿔주는 것을 ..
    //

    public MemberInfoResponseDTO findMemberById(Long id){

        System.out.println("findAllmembers Service method call...");


        return changeToDTO(memberDAO.findMemberById(id));
    }


    private MemberInfoResponseDTO changeToDTO(Member member){
        MemberInfoResponseDTO dto = new MemberInfoResponseDTO();
        dto.setId(member.getId());
        dto.setName(member.getName());

        return dto;
    }
}
