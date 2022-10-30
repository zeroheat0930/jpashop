package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //내장타입
@Getter

//값이라는견 변경되면 안됨 그래서 Setter 제공 xx

public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    protected Address() {
    } //함부로 new로 생성하지말라고 달아놓는거
    //JPA 스펙상 엔태티나 임베디드 타입( @Embeddable )은 자바 기본 생성자(default constructor)를 public 또는 protected 로 설정해야 한다
}
