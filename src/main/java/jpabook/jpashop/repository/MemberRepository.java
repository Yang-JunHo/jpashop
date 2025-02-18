package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member); // 영속성컨테스트에서 멤버 객체를 넣는다 -> 커밋 시점에 db에 반영됨
    }

    public Member findOne(Long id){
        return em.find(Member.class, id); // 단건조회(타입, pk)
    }

    public List<Member> findAll(){
        return em.createQuery("select m from member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
