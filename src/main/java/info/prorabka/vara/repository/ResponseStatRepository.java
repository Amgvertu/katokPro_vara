package info.prorabka.vara.repository;

import info.prorabka.vara.entity.ResponseStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseStatRepository extends JpaRepository<ResponseStat, Long>, JpaSpecificationExecutor<ResponseStat> {
    // Все методы удалены, теперь используем спецификации
}
