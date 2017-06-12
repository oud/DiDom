package com.didom.myapp.repository;

import com.didom.myapp.domain.Contract;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Contract entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {

    @Query("select distinct contract from Contract contract left join fetch contract.users")
    List<Contract> findAllWithEagerRelationships();

    @Query("select contract from Contract contract left join fetch contract.users where contract.id =:id")
    Contract findOneWithEagerRelationships(@Param("id") Long id);

}
