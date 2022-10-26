/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.util.Constants;
import com.example.demo.util.ResponseJson;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess,
            String errorMessage, HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(obj);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
//        LOG.info("response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess,
            String errorMessage, HttpStatus httpStatus, Long totalRecord) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(obj);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        objResponse.setTotal(totalRecord);
//        LOG.info("response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    public ResponseEntity<ResponseJson> createSuccessResponse(Object obj, HttpStatus httpStatus) {
        return createResponse(obj, true, "", httpStatus);
    }

    public ResponseEntity<ResponseJson> createErrorResponse(Object obj, String errorMessage, HttpStatus httpStatus) {
        return createResponse(obj, false, errorMessage, httpStatus);
    }

    public ResponseEntity<ResponseJson> createErrorResponse(String errorMessage, HttpStatus httpStatus) {
        return createResponse(null, false, errorMessage, httpStatus);
    }

    protected ResponseEntity<ResponseJson> createResponseDownload(byte[] res, String fileName, HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(Base64.encodeBase64String(res));//new String()
        objResponse.setSuccess(true);
        objResponse.setMessage(fileName);
//        LOG.info("download response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    protected String getErrorInfo(String tag, Exception error) {
        return Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + tag
                + Constants.MESSAGE_SEPARATOR + error.getStackTrace()[1].getMethodName()
                + Constants.MESSAGE_SEPARATOR + error.toString();
    }

    protected File base64ToFile(String base64FileData, File file) {
        byte data[] = Base64.decodeBase64(base64FileData);
        FileOutputStream fos = null;
        try {
            //File file = new File(filePath);
            fos = new FileOutputStream(file);
            fos.write(data);
            return file;
        } catch (Exception e) {
            LOG.error("BaseController::base64ToFile", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    LOG.error("BaseController::base64ToFile::close", ex);
                }
            }
        }
        return null;
    }

    protected File base64ToFile(String base64FileData, String filePath) {
        return base64ToFile(base64FileData, new File(filePath));
    }

    protected List<Long> getIdsFromString(String strIds) {
        List<Long> lstIds = new ArrayList<>();
        String[] arrIds = strIds.split("_");
        if (arrIds != null && arrIds.length > 0) {
            for (int i = 0; i < arrIds.length; i++) {
                if (!"".equals(arrIds[i].trim())) {
                    lstIds.add(Long.valueOf(arrIds[i].trim()));
                }
            }
        }
        return lstIds;
    }

    public ResponseEntity<ResponseJson> createSuccessResponse(Object obj, HttpStatus httpStatus, Long totalRecord) {
        return createResponse(obj, true, "", httpStatus, totalRecord);
    }

}
