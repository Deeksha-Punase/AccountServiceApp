package com.test.GetAccountsService_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.GetAccountsService_v1.domain.AccountDomain;

@Repository
public interface AccountRepository extends JpaRepository<AccountDomain, Integer>{

	@Query(value="select acc from AccountDomain acc where accountId=:id")
	AccountDomain findByAccountId(@Param("id") Integer id);

}
