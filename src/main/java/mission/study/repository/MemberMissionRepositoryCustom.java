package mission.study.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import mission.study.domain.mapping.MemberMission;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryCustom {
    private final EntityManager em;
    public Boolean findByMemberMissionId(Long memberId, Long missionId) {
        String jpql = "SELECT count(m) FROM MemberMission m WHERE m.member.id = :memberId AND m.mission.id = :missionId";
        Long count = (Long) em.createQuery(jpql)
                .setParameter("memberId", memberId)
                .setParameter("missionId", missionId)
                .getSingleResult();
        return count > 0;
    }
}
