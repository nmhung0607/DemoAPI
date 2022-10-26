package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {
	  List<Department> findALL();
	  Department addDepartment(Department department);
	  Department update(long id ,Department department);
	  List<Department> detailsDepartment(long id);
	  List<Department> findAllPaging(int pageNumber, int pageSize);
	  Department delete(long id);
	  List<Department> layDanhSach(String name, String address, long code,long id);
	  List<Department> detailsDepartmentByTen(String name);
	  List<Department> detailsDepartmentByCode(long code);
	  List<Department> detailsDepartmentByAddress(String address);
} 
