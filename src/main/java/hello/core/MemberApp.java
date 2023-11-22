package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImple();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(findmember.getName());
    }
}
