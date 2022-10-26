package com.example.demo.repositories;

import com.example.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @author Dell on 10/12/2022
 */
public interface NhanVienRepositoryCustom {
    List<NhanVien> fillByTen(@Value("ten") String ten);
    List<NhanVien> fillByTenNative(String ten);
    
}
