package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.repositories.NhanVienRepository;
import com.example.demo.repositories.NhanVienRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dell on 10/12/2022
 */
@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService {
    private static final Logger LOG = LoggerFactory.getLogger(NhanVienServiceImpl.class);

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> layDanhSachNhanVien(String ten, Long type) {
        List<NhanVien> result = new ArrayList<>();
        try {
            if (type == 0) {
                result = nhanVienRepository.findAllByTen(ten);
            } else if(type == 1) {
                result = nhanVienRepository.getByTen(ten);
            } else if(type == 2) {
                result = nhanVienRepository.searchByTen(ten);
            } else if(type == 3) {
                result = nhanVienRepository.fillByTen(ten);
            } else if(type == 4) {
                result = nhanVienRepository.fillByTenNative(ten);
            }
        } catch (Exception ex) {
            LOG.error("layDanhSachNhanVien: " + ex.getMessage());
        }
        return result;
    }
}
