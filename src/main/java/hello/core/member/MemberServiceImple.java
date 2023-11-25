package hello.core.member;

public class MemberServiceImple implements MemberService{

    //DI를 위배한다 추상화, 구체화 둘다 의존
    private final MemberRepository memberRepository;

    public MemberServiceImple(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public  void join(Member member){
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
