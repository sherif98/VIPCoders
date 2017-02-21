package com.edu.vips.dao.api;

import com.edu.vips.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
}
