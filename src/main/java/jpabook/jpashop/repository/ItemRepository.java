package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {// 완전새로생성
            em.persist(item);
        }else {//이미 등록된것을 가져옴
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item as i", Item.class)
                .getResultList();
    }
}
