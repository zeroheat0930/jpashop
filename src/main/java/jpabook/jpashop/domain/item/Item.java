package jpabook.jpashop.domain.item;


import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속관계 매핑하면서 싱글테이블 전략해서 한테이블에 다 떄려박기
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //비지니스로직//

    //재고증가
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    //재고감소
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        //재고가 0 이하일때 익샙션 발생
        if(restStock<0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
