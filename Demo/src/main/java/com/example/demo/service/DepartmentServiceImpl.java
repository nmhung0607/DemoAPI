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
        public List<Department> getResult(long id , long is_delete,String name, String address , long status ,int pageSize , int pageNumber) {
            List<Department> result = new ArrayList<>();
                result.addAll(departmentRepository.fillByAll(id,is_delete,name,address, status, pageNumber, pageSize));
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
					    department.setStatus(a.getStatus());
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
		public Department getDepartment(long id) {
			
			return departmentRepository.getDetails(id);
			
		}
		public Department getDepartmentByTen(String name) {
		
			return departmentRepository.getDetailsByTen(name);
			
		}
		public Department getDepartmentByCode(long code) {

			return departmentRepository.getDetailsByCode(code);
			
		}
		public Department getDepartmentByAddress(String address) {
			return departmentRepository.getDetailsByAddress(address);
		
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
