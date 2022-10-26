package com.example.demo.service;

import com.example.demo.model.NhanVien;


import java.util.List;

/**
 * @author Dell on 10/12/2022
 */
public interface NhanVienService {
    List<NhanVien> layDanhSachNhanVien(String ten, Long type);
}
