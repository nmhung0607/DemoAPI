package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {
	  List<Department> findALL();
	  Department addDepartment(Department department);
	  Department update(long id ,Department department);
	  Department getDepartment(long id);
	  List<Department> findAllPaging(int pageNumber, int pageSize);
	  Department delete(long id);

	  Department getDepartmentByTen(String name);
	  Department getDepartmentByCode(long code);
	  Department getDepartmentByAddress(String address);
	  List<Department> getResult(long id, long is_delete, String name, String address, long status, int pageSize,int pageNumber);
} 
