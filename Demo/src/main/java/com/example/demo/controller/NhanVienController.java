package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.NhanVienService;
import com.example.demo.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dell on 10/12/2022
 */
@RestController
@RequestMapping("/NhanVien")
@Scope("request")
public class NhanVienController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(NhanVienController.class);

    @Autowired
    NhanVienService nhanVienService;

    @PostMapping(value = "/search")
    public ResponseEntity<ResponseJson> search(@RequestBody NhanVien searchData) {
        try {
            if (searchData == null) {
                return createErrorResponse("Not found", HttpStatus.NOT_FOUND);
            }
            List<NhanVien> result = nhanVienService.layDanhSachNhanVien(searchData.getTen(), searchData.getType());

            if (null != result) {
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                return createErrorResponse("Not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            LOG.error("search" + ex.getMessage(), ex);
            return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/demo")
    public String helo(){
        return "hi";
    }
}
