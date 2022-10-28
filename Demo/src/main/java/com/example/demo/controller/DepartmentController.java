package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.util.ResponseJson;

@RestController
@RequestMapping("/api")
public class DepartmentController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DepartmentRepository repository;

	@PostMapping(value = "/department")
	public ResponseEntity<ResponseJson> addDepartment(@RequestBody Department department) {
		try {
			Department dataDepartment = departmentService.addDepartment(department);
			if (dataDepartment != null) {
				return createSuccessResponse(dataDepartment, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return addDepartment(department);
	}
	@GetMapping(value = "/find/department")
	public ResponseEntity<ResponseJson> findEachDepartment(
			@RequestParam("id") long id ,
			@RequestParam("is_delete") long is_delete,
			@RequestParam(value = "name" , required = false) String name,
			@RequestParam(value = "address" , required = false) String address,
			@RequestParam("status") long status,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize) {
		try {
			List<Department> department = departmentService.getResult(id, is_delete, name, address, status , pageSize, pageNumber);
			if (department != null) {
				return createSuccessResponse(department, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@GetMapping(value = "/find/department/id")
	public ResponseEntity<ResponseJson> findDepartment(@PathVariable("id") long id) {
		try {
			List<Department> department = departmentService.getDepartment(id);
			if (department != null) {
				return createSuccessResponse(department, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@GetMapping(value = "/find/department/name")
	public ResponseEntity<ResponseJson> findByTenDepartment(@RequestParam("name") String name) {
		try {
			List<Department> department=departmentService.getDepartmentByTen(name);
			if(department!=null) {
				return createSuccessResponse(department, HttpStatus.OK);
			}
		}
		catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	@GetMapping(value = "/find/department/code")
	public ResponseEntity<ResponseJson> findByCodeDepartment(@PathVariable("code") long code) {
		try {
			List<Department> department=departmentService.getDepartmentByCode(code);
			if(department!=null) {
				return createSuccessResponse(department, HttpStatus.OK);
			}
		}
		catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	@GetMapping(value = "/find/department/address")
	public ResponseEntity<ResponseJson> findByAddressDepartment(@RequestParam("address") String address) {
		try {
			List<Department> department=departmentService.getDepartmentByAddress(address);
			if(department!=null) {
				return createSuccessResponse(department, HttpStatus.OK);
			}
		}
		catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@PutMapping(value = "/department/update")
	public ResponseEntity<ResponseJson> updateDepartment(@RequestParam("id") long id,
			@RequestBody Department department) {
		try {
			Department depart = departmentService.update(id, department);
			if (depart != null) {
				return createSuccessResponse(depart, HttpStatus.OK);
			}
		} catch (Exception ex) { 
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return updateDepartment(id, department);
	}

	@PutMapping(value = "/department/delete")
	public ResponseEntity<ResponseJson> deleteDepartment(@RequestParam("id") long id) {
		try {
			Department depart = departmentService.delete(id);
			if (depart != null) {
				return createSuccessResponse(depart, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return deleteDepartment(id);
	}

	@GetMapping(value = "/paging")
	public List<Department> showDepartment(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize) {
		List<Department> depart = departmentService.findAllPaging(pageSize, pageNumber);
		try {

			if (depart != null) {
				return depart;
			}
		} catch (Exception ex) {
			return null;
		}
		return null;
	}
}
