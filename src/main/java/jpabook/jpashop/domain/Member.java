package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //내장햇다 라는 어노테이션
    private Address address;

    @OneToMany(mappedBy = "member")//1대 다 관계, 연관관계에서 주인이 x
    private List<Order> orders = new ArrayList<>();


}
