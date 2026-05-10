package library;

import library.model.Member;
import library.repository.MemberRepository;
import library.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(new MemberRepository());
    }

    @Test
    void addMember_validData_success() {
        Member member = memberService.addMember("M001", "Болд", "bold@email.com", "99001122");
        assertNotNull(member);
        assertEquals("Болд", member.getName());
    }

    @Test
    void addMember_emptyName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            memberService.addMember("M001", "", "bold@email.com", "99001122"));
    }

    @Test
    void addMember_emptyEmail_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            memberService.addMember("M001", "Болд", "", "99001122"));
    }

    @Test
    void getAllMembers_returnsAll() {
        memberService.addMember("M001", "Болд", "bold@email.com", "99001122");
        memberService.addMember("M002", "Сараа", "saraa@email.com", "99334455");
        assertEquals(2, memberService.getAllMembers().size());
    }

    @Test
    void getMemberById_exists_returnsPresent() {
        memberService.addMember("M001", "Болд", "bold@email.com", "99001122");
        assertTrue(memberService.getMemberById("M001").isPresent());
    }

    @Test
    void getMemberById_notExists_returnsEmpty() {
        assertTrue(memberService.getMemberById("M999").isEmpty());
    }

    @Test
    void deleteMember_exists_returnsTrue() {
        memberService.addMember("M001", "Болд", "bold@email.com", "99001122");
        assertTrue(memberService.deleteMember("M001"));
    }

    @Test
    void deleteMember_notExists_returnsFalse() {
        assertFalse(memberService.deleteMember("M999"));
    }
}