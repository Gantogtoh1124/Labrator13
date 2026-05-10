package library.repository;

import library.model.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {
    private List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public Optional<Member> findById(String id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    public boolean delete(String id) {
        return members.removeIf(m -> m.getId().equals(id));
    }
}