package com.ohgiraffers.thymeleaf.application.controller;
import com.ohgiraffers.thymeleaf.application.dto.SelectCriteria;
import org.springframework.web.bind.annotation.GetMapping;
import com.ohgiraffers.thymeleaf.application.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("lecture")
//상위 요청을 lecture로 설정하여 밑에 중복되는 lecture를 사용하지 않아도 됨
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){
        //model과 view를 합친 객체 값을 담을게 있으면 model에 넣어주고 view로 이동?

        mv.addObject("hello", "<h3>hello world</h3>");
        mv.addObject("member",new MemberDTO("홍길동",20,'남',"서울시"));

        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){

        mv.addObject("num",1);
        mv.addObject("str","바나나");


        List<MemberDTO>members= new ArrayList<>();
        members.add(new MemberDTO("홍",20,'남',"서울시 서초구"));
        members.add(new MemberDTO("유",22,'여',"서울시 노원구"));
        members.add(new MemberDTO("장",40,'남',"서울시 종로구"));
        members.add(new MemberDTO("신",30,'여',"서울시 성북구"));


        mv.addObject("members",members);


        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){


        SelectCriteria selectCriteria= new SelectCriteria(1,10,3);
        mv.addObject(selectCriteria);
        //key값이 없이 그냥 넣으면 변수명이 key값이 됨


        return mv;
    }
}
