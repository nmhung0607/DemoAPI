package com.example.demo.repositories;

import com.example.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dell on 10/12/2022
 */
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>, NhanVienRepositoryCustom {
    List<NhanVien> findAllByTen(String ten);

    @Query("select n from NhanVien n where n.ten like :ten escape '/' ")
    List<NhanVien> searchByTen(@Param("ten") String ten);

    @Query(value = "select * from Nhan_Vien n where n.ten like :ten escape '/' ", nativeQuery = true)
    List<NhanVien> getByTen(@Param("ten") String ten);
}
