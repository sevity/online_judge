package com.sevity.authservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable { // Serializable 인터페이스 구현

    private static final long serialVersionUID = 1L; // serialVersionUID 추가

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;


    @ManyToMany(fetch = FetchType.EAGER)  //@ManyToMany : 이 어노테이션은 한 객체가 다른 객체들과 많은 관계를 가질 수 있음을 나타냅니다. EAGER옵션의 경우 User 엔티티를 조회할 때 연관된 Role 엔티티도 함께 로드하려는 경우이며 성능최적화관점이고 정합성에는 영향을 주지 않음
    @JoinTable(name = "user_roles",  //@JoinTable : 다대다 관계를 표현하기 위해 보통 중간에 연결 테이블이 필요합니다. @JoinTable 어노테이션은 이 연결 테이블의 정보를 제공합니다.
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference  //이게 없으면 무한반복 로그로 죽어버림
    private Set<Role> roles;
}
