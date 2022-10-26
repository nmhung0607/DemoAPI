package com.example.demo.service;

import java.util.ArrayList;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repositories.DepartmentRepository;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	    private static final Logger LOG = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	    @Autowired
	    DepartmentRepository departmentRepository;
        @PersistenceContext 
        private EntityManager em;
        @Override
        public List<Department> layDanhSach(String name, String address ,long code,long id) {
            List<Department> result = new ArrayList<>();
                if (id>0) {
                	result.addAll(departmentRepository.getDetails(id));
                }
                if (name!=null) {
                	result.addAll(departmentRepository.getDetailsByTen(name));            
                }
                if(address!=null ) {
                    result.addAll(departmentRepository.getDetailsByAddress(address));
                }
                if(code>=0) {
                	result.addAll(departmentRepository.getDetailsByCode(code));
                }
                Set<Department> set = new LinkedHashSet<Department>(result);
                List<Department> results = new ArrayList<Department>(set);
            
            return results;
        }
		@Override
		public List<Department> findALL() {
			List<Department> result = new ArrayList<>();
	    	return result=departmentRepository.findAll();
		}
		@Override
		public Department addDepartment(Department department) {
			if(department!=null) {
				return departmentRepository.save(department);
			}
			return null;
		}
		@Override
		public Department update(long id,Department a) {
			try {
				if (a !=null) {
					Department department = departmentRepository.findById(id).get();
					if (department!=null) {
						department.setName(a.getName());
					    department.setCode(a.getCode());
					    department.setAddress(a.getAddress());
					    department.setPath(a.getPath());
					    department.setStt(a.getStt());
					    department.setIs_delete(a.getIs_delete());
					    department.setP_id(a.getP_id());
					    return departmentRepository.save(department);
					}
				}
			}
			catch (Exception e) {
				LOG.error("update department : " + e.getMessage());
			}
			return null;
		}
		@Override
		public List<Department> detailsDepartment(long id) {
			List<Department> listDepartment = new ArrayList<>(); 
			listDepartment=departmentRepository.getDetails(id);
			if (listDepartment.isEmpty()) {
				return null;
			}
			return listDepartment;
		}
		public List<Department> detailsDepartmentByTen(String name) {
			List<Department> listDepartment = new ArrayList<>(); 
			listDepartment=departmentRepository.getDetailsByTen(name);
			if (listDepartment.isEmpty()) {
				return null;
			}
			return listDepartment;
		}
		public List<Department> detailsDepartmentByCode(long code) {
			List<Department> listDepartment = new ArrayList<>(); 
			listDepartment=departmentRepository.getDetailsByCode(code);
			if (listDepartment.isEmpty()) {
				return null;
			}
			return listDepartment;
		}
		public List<Department> detailsDepartmentByAddress(String address) {
			List<Department> listDepartment = new ArrayList<>(); 
			listDepartment=departmentRepository.getDetailsByAddress(address);
			if (listDepartment.isEmpty()) {
				return null;
			}
			return listDepartment;
		}
		@Override
		public Department delete(long id) {
			try {
				Department department = departmentRepository.findById(id).get();
				if (department!=null) {
					 department.setIs_delete(1);
					 return departmentRepository.save(department);
				}
			}
			catch (Exception e) {
				LOG.error("delete department : " + e.getMessage());
			}
			return null;
		}
		@Override
		public List<Department> findAllPaging(int pageNumber, int pageSize) {
			
			return departmentRepository.fillByTenNative(pageNumber,pageSize);
		}
}
