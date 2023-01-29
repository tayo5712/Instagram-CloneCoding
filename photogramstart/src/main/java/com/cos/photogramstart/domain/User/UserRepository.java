package com.cos.photogramstart.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

// 어노테이션이 없어도 JpaRepository IoC등록이 자동으로 된다.
public interface UserRepository extends JpaRepository<User, Long> {
    // JPA query method (자동으로 쿼리 만들어 줌)
    User findByUsername(String username);
}
