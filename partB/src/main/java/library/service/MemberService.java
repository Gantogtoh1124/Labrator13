package library.service;

import library.model.Member;
import library.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(String id, String name, String email, String phone) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email cannot be empty");
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email format");
        Member member = new Member(id, name, email, phone);
        memberRepository.save(member);
        return member;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    public boolean deleteMember(String id) {
        return memberRepository.delete(id);
    }
}