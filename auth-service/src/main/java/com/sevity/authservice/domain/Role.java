package com.sevity.authservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //아래 users는 이역할(예를들어 name="ROLE_ADMIN")을 가지는 모든 user를 의미함. online judge에서는 필요없을수 있으나 학습용으로 유지함.
    //User와 Role은 n:n관계 이지만 관계의 주인은 User쪽에 있다. 왜냐면 mappedBy키워드를 쓰는순간 spring JPA에서 노예로 판정함!
    //JPA에서는 관계의 주인쪽에서만 데이터베이스 연산이 수행됨!!!
    //mappedBy = "roles"는 User.java안의 User class의 roles 멤버변수를 의미
    //문자열형태로 표현하는 이유는 Java에서 직접적인 참조를 할경우 상호참조 형태가 되어 순환참조 문제를 일으킬 수 있기 때문
    @ManyToMany(mappedBy = "roles")
    @JsonBackReference // 이게 없으면 무한반복 오류로 죽어버림
    private Set<User> users;
    // getter, setter, etc.
}
