//UserRepository 인터페이스는 User 엔티티에 대한 CRUD(Create, Read, Update, Delete) 연산을 수행하는 메서드를 제공합니다. 
//이 인터페이스를 통해 데이터베이스에 User 엔티티를 저장하거나, User 엔티티를 조회할 수 있습니다. 
//UserRepository 인터페이스는 JpaRepository 인터페이스를 확장하므로, Spring Data JPA가 UserRepository 인터페이스에 대한 구현 클래스를 자동으로 생성해줍니다. 
//이 구현 클래스를 통해 User 엔티티를 데이터베이스에 저장하거나, 데이터베이스로부터 User 엔티티를 조회할 수 있습니다.
package com.sevity.authservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
