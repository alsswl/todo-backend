package backend.likelion.todos.goal;

import backend.likelion.todos.common.ForbiddenException;
import backend.likelion.todos.common.NotFoundException;
import backend.likelion.todos.member.Member;
import backend.likelion.todos.member.MemberRepository;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final MemberRepository memberRepository;
    private final GoalRepository goalRepository;

    // 목표를 저장하고 저장된 목표의 ID를 반환합니다.
    public Long save(String name, String color, Long memberId) {
        if(memberRepository.findById(memberId).isEmpty()){
            throw new NotFoundException("회원 정보가 없습니다.");
        }
        Goal newGoal = new Goal(name,color,memberRepository.findById(memberId).get());
        return goalRepository.save(newGoal).getId();
    }

    // 주어진 정보로 목표를 업데이트합니다.
    public void update(Long goalId, String name, String color, Long memberId) {
        if(memberRepository.findById(memberId).isEmpty()){
            throw new NotFoundException("회원 정보가 없습니다.");
        }
        if(goalRepository.findById(goalId).isEmpty()){
            throw new NotFoundException("목표 정보가 없습니다.");
        }
        if(!Objects.equals((goalRepository.findById(goalId).get()).getMember().getId(), memberId)){
            throw new ForbiddenException("해당 목표에 대한 권한이 없습니다.");
        }
        goalRepository.findById(goalId).get().setColor(color);
        goalRepository.findById(goalId).get().setName(name);
    }

    // 목표를 삭제합니다.
    public void delete(Long goalId, Long memberId) {
        // TODO [2단계] memberId를 사용하여 회원 정보를 조회하고, 없으면 "회원 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        // TODO [2단계] goalId를 사용하여 목표 정보를 조회하고, 없으면 "목표 정보가 없습니다." 메시지와 함께 NotFoundException을 발생시키세요.
        // TODO [2단계] 조회한 목표가 주어진 회원의 것인지 검증하세요.
        // TODO [2단계] goalRepository에서 해당 목표를 삭제하세요.
    }

    // 특정 회원 ID에 속하는 모든 목표를 조회하여 GoalResponse 리스트로 반환합니다.
    public List<GoalResponse> findAllByMemberId(Long memberId) {
        // TODO [2단계] memberId를 사용하여 모든 목표를 조회하세요.
        // TODO [2단계] 조회된 목표 리스트를 GoalResponse 리스트로 변환하여 반환하세요.
        return null;
    }
}
