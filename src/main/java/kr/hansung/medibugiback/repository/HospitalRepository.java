package kr.hansung.medibugiback.repository;

import kr.hansung.medibugiback.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {


    Hospital findByHoscnt(Long hoscnt);

    List<Hospital> findByMediDepart(String depart);
    boolean existsByTelno(String tel);

    List<Hospital> findByAddrStartingWith(String addr);

    List<Hospital> findByAddrStartingWithAndMediDepart(String sido, String depart);

    List<Hospital> findByAddrStartingWithAndAddrContaining(String sido,String sggu);

    List<Hospital> findByAddrStartingWithAndAddrContainingAndMediDepart(String sido, String sggu, String depart);
}
