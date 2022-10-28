package com.example.demo.repositories;

import java.util.Collection;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long>,DepartmentRepositoryCustom{
//	 List<Department> findAllByTen(String name);
//	
//	  @Query("select n from Department n where n.DE_NAME like :name escape '/' ")
//	 List<Department> searchByTen(@Param("name") String name);
//	
//	 @Query(value = "select * from DON_VI n where n.DE_NAME like :name escape '/' ", nativeQuery = true)
//	 List<Department> getByTen(@Param("name") String name);
	 @Query(value = "select n from Department n where n.id=:id")
	 Department getDetails(@RequestParam("id") long id);
	 @Query(value = "select n from Department n where n.name like :name")
	 Department getDetailsByTen(@RequestParam("name") String name);
	 @Query(value = "select n from Department n where n.code=:code")
	 Department getDetailsByCode(@RequestParam("code") long code);
	 @Query(value = "select n from Department n where n.address like :address")
	 Department getDetailsByAddress(@RequestParam("address") String address);
	 
}
