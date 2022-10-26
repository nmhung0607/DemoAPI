package com.example.demo.repositories;

import com.example.demo.model.NhanVien;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dell on 10/12/2022
 */
public class NhanVienRepositoryImpl implements NhanVienRepositoryCustom {
    private static final Logger LOG = LoggerFactory.getLogger(NhanVienRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    //lay data su dung hibernate query
    @Override
    public List<NhanVien> fillByTen(String ten) {
        List<NhanVien> result = new ArrayList<>();
        try {
            String sql = "select n from NhanVien n where n.ten like :ten escape '/' ";
            Query query = em.createQuery(sql);
            query.setParameter("ten", ten);
            query.setFirstResult(0);
            query.setMaxResults(10);
            result = query.getResultList();
        } catch (Exception ex) {
            LOG.error("fillByTen: " + ex.getMessage());
        }
        return result;
    }

    //lay data su dung native query
    @Override
    public List<NhanVien> fillByTenNative(String ten) {
        List<NhanVien> result = new ArrayList<>();
        try {
            String sql = "select * from Nhan_Vien n where n.ten like :ten escape '/' ";
            Query query = em.createNativeQuery(sql);
            query.setParameter("ten", ten);
            query.setFirstResult(0);//phan trang, lay tu phan tu thu 0 trong list, max lay 10 phan tu
            query.setMaxResults(10);
            result = query.getResultList();
        } catch (Exception ex) {
            LOG.error("fillByTenNative: " + ex.getMessage());
        }
        return result;
    }
}
