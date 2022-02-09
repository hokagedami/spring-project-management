package com.codekage.pma.dao;

import com.codekage.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserAccount, Long> {
}
