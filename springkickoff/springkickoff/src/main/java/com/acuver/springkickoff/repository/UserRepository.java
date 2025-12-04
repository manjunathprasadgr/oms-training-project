package com.acuver.springkickoff.repository;

import com.acuver.springkickoff.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {
}
