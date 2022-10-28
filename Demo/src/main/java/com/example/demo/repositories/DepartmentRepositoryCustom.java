package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Department;

public interface DepartmentRepositoryCustom {
//	List<Department> fillByTen(@Value("name") String name);
    List<Department> fillByTenNative(int pageNumber , int pageSize);

	List<Department> findByTen(String name);

	List<Department> findByAddress(String address);

	List<Department> findByCode(long code);

	List<Department> fillByAll(long id, long is_delete, String name, String address, long status, int pageNumber,
			int pageSize);

    
}
