package kr.hansung.medibugiback.repository;

import kr.hansung.medibugiback.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {

    Hospital findByYadmNm(String name);

    List<Hospital> findAll();

    boolean existsByTelno(String tel);
}
