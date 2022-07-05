package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
abstract public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Category> categories = new ArrayList<>();


    //====비즈니스
    public void addStock(int quantity){
        this.stockQuantity = quantity;
    }

    public void removeStock(int quantity){
        int nowStock = this.stockQuantity - quantity;
        if (nowStock < 0){
            throw new NotEnoughStockException("need more stock");
        }

        this.stockQuantity = nowStock;
    }
}
