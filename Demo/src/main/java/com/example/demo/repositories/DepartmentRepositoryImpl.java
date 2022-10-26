package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.model.Department;

public class DepartmentRepositoryImpl implements DepartmentRepositoryCustom{
	    private static final Logger LOG = LoggerFactory.getLogger(DepartmentRepositoryImpl.class);
	 
         @PersistenceContext
	     private EntityManager em;
         @Override
	     //lay data su dung hibernate query
	     public List<Department> findByTen(String name) {
	         List<Department> result = new ArrayList<>();
         try {
	             String sql = "select n from Department n where n.name like :name";
	             Query query = em.createQuery(sql);
	             query.setParameter("name", name);
	             result = query.getResultList();
	         } catch (Exception ex) {
	             LOG.error("findByTen: " + ex.getMessage());
	         }
	         return result;
	     }
	     @Override
	     public List<Department> findByAddress(String address) {
	         List<Department> result = new ArrayList<>();
         try {
	             String sql = "select n from Department n where n.address like :address";
	             Query query = em.createQuery(sql);
	             query.setParameter("address", address);
	             result = query.getResultList();
	         } catch (Exception ex) {
	             LOG.error("findByTen: " + ex.getMessage());
	         }
	         return result;
	     }
	     @Override
	     public List<Department> findByCode(long code) {
	         List<Department> result = new ArrayList<>();
         try {
	             String sql = "select n from Department n where n.code =:code";
	             Query query = em.createQuery(sql);
	             query.setParameter("code", code);
	             result = query.getResultList();
	         } catch (Exception ex) {
	             LOG.error("findByTen: " + ex.getMessage());
	         }
	         return result;
	     }
	 
	     //lay data su dung native query
	     @Override
	     public List<Department> fillByTenNative(int pageNumber , int pageSize) {
	         List<Department> result = new ArrayList<>();
	         try {
	             String sql = "select * from DON_VI";
	             Query query = em.createNativeQuery(sql, Department.class);
//	             query.setParameter("name", name);
	             query.setFirstResult((pageNumber-1)*pageSize);//phan trang, lay tu phan tu thu 0 trong list, max lay 10 phan tu
	             query.setMaxResults(pageSize);
	             result = query.getResultList();
	         } catch (Exception ex) {
	             LOG.error("fillByTenNative: " + ex.getMessage());
	         }
	         return result;
	     }
	     }