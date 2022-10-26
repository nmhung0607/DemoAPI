/*
 * Copyright (C) 2010 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.util;

import java.util.Objects;

public final class Constants {

    public static final String CLIENT_ID = "1GATE";
    public static final String AUTH_HEADER_STRING = "Authorization";
    public static final String IP_HEADER_STRING = "IP";
    public static final Integer TOKEN_DURATION = 3600*6;// active token  in 6 hours

    public interface EFILE {

        interface ESB {


            interface ATTACHMENT_TYPE {
                Long KET_QUA_KY_SO = 1L;
            }
        }
    }

        public interface MODULE_TYPE {
            Long CAU_HOI = 4L;

        }

        public interface Attachment {
            interface ObjectType {
                Long TRINH_KY_PHIEU_TRINH = 113L;
                Long TRINH_KY_DU_THAO = 114L;
                Long TRINH_KY_VB_LIEN_QUAN = 115L;
            }
        }

        public interface PAGE {
            int DEFAULT_PAGE_SIZE = 10;
            int DEFAULT_PAGE_NUMBER = 0;
        }

        public interface QUESTION {
            interface HAS_RESULT {
                Long TRUE = 1L;
                Long FALSE = null;
            }

        }

        public interface QUESTION_TYPE {


        }

        public interface STEP {
            interface TYPE {
                Long BAT_DAU = 1L; // node bat dau
                Long KET_THUC = 2L;// node ket thuc
                Long THUONG = 3L; //node o giua
            }

        }

        /**
         * Status 0: delete; 1: active
         */
        public interface Status {
            Long DEFAULTED = 1l;
            Long NOT_DEFAULT = 0l;
            public static final Long ACTIVE = 1L;
            public static final Long INACTIVE = 0L;
            public static final Long DELETE = -1L;
        }

        public interface USER_REGISTER {
            interface APPROVE_STATUS {
                Long MOI_DANG_KY = 1l;
                Long TU_CHOI = 2l;
                Long DA_PHE_DUYET = 3l;
            }

            interface LOAI_TAI_KHOAN {
                Long CA_NHAN = 1l;
                Long DOANH_NGHIEP = 2l;

                String CA_NHAN_STR = "Cá nhân";
            }
        }


        public interface DELETED_STATUS {

            public static final Long NOT_DELETED = 0L;
            public static final Long DELETED = 1L;
        }

        public interface LOCK_TYPE {

            public static final Long LOCK = 0L;
            public static final Long UN_LOCK = 1L;
        }

        public interface DEPT_USER_TYPE {

            public static final Long DEPARTMENT = 0L;
            public static final Long USER = 1L;
        }

        public static final String APP_NAME = "SettingService";
        public static final String MESSAGE_SEPARATOR = "\\{}";


        //Thêm đê test hồ sơ
        public interface OBJECT_TYPE {
            public static Long USER = 1L;
            //        public static Long ATTACHMENT = 2L;
            public static Long DEPARTMENT = 3L;
            public static Long MENU = 4L;
            public static Long POSITION = 5L;
            public static Long ROLE = 6L;
            public static Long CATEGORY = 7L;
            public static Long GROUP_USER = 8L;
            public static Long CATEGORY_GROUP = 9L;
            public static Long REST_DAY = 10L;
            public static Long SYSTEM_COMPONENT = 11L;
            public static Long BOOK = 12L;
            public static Long DOCIN = 13L;
            public static Long DOCOUT = 14L;
            public static Long WORK_PROFILE = 15L;
            public static Long CONFIG = 16L;
            public static Long PROFILE_STORE_DOC_RELATION = 17L;
            public static Long PROFILE_STORY = 18L;
            public static Long WORKING_SHEET_PROFILE = 19L;
            public static Long PROFILE_CANCEL = 20L;
            public static Long GROUP_ROLE = 21L;
            public static Long PROCEDURE_TEMPLATE = 22L;
            Long INVOICE_ATTACMENT = 23L;


            public interface PROFILE_HISTORY {

                public static final Long WORK_PROFILE = 1L;
            }

            public interface DOC_RELATION {

                public static final Long DOC_IN = 0L;
            }

            public interface COMMENTS {

                public static final Long DOC_IN = 1L;
            }
        }

        public interface ATTACHMENT {
            interface OBJECT_TYPE {
                public static final Long DOC_IN = 1L;
                public static final Long DOC_OUT = 2L;
                public static final Long WORK_PROFILE = 3L;
                public static final Long QR_CODE = 13L;
                public static final Long BAR_CODE = 14L;
                public static final Long PROCEDURE_TEMPLATE = 22L;
                public static final String EFILE_QR_CODE = "QR_CODE";
                public static final String EFILE_BAR_CODE = "BAR_CODE";
            }
        }

        public interface COMMENTS_TYPE {

            public static final Long OPINION = 1L;
            public static final Long ANSER = 2L;
        }

        public interface WORK_PROFILE {

            public interface RELATION_TYPE {

                public static final Long DOC_IN = 1L;
                public static final Long DOC_OUT = 2L;
            }
        }

        public enum ProcessType {

            MAIN_PROCESS(Long.valueOf("0"), "Xử lý chính"),
            COMBINE_PROCESS(Long.valueOf("1"), "Phối hợp");

            private Long processTypeCode;
            private String processTypeName;

            private ProcessType(Long processTypeCode, String processTypeName) {
                this.processTypeCode = processTypeCode;
                this.processTypeName = processTypeName;
            }

            public Long getProcessTypeCode() {
                return processTypeCode;
            }

//            public void setProcessTypeCode(Long processTypeCode) {
//                this.processTypeCode = processTypeCode;
//            }

            public String getProcessTypeName() {
                return processTypeName;
            }

//            public void setProcessTypeName(String processTypeName) {
//                this.processTypeName = processTypeName;
//            }

            public static ProcessType getByProcessTypeCode(Long processTypeCode) {
                for (ProcessType typeCodeObject : ProcessType.values()) {
                    if (Objects.equals(typeCodeObject.getProcessTypeCode(), processTypeCode)) {
                        return typeCodeObject;
                    }
                }
                return null;
            }

            public static String standardizedAttachTypeName(Long attachmentTypeCode, String attachmentTypeName) {
                ProcessType attachmentType = getByProcessTypeCode(attachmentTypeCode);
                if (attachmentTypeCode != null && attachmentType != null) {
                    attachmentTypeName = attachmentType.getProcessTypeName();
                }
                return attachmentTypeName;
            }
        }// hết đoạn thêm

        public interface PROCEDURE {
            public interface Is_Receive_Online {
                public static final Long Online = 1L;
                public static final Long No_Online = 0L;
            }

        }

        public interface ELEMENT_RELATIONSHIP {
            public interface DEPEND_TYPE {
                public static final Long AN_HIEN = 0L;
                public static final Long DU_LIEU = 1L;
            }
        }

        public interface SYNC {
            interface IS_SYNC {
                Long SYNC = 1L;
                Long SYNC_UP = 2L;
                Long NOT_SYNC = null;
            }

            interface CATEGORY_SYNC {
                String GENDER = "LayDanhMucGioiTinh";
                String PROVINCE = "LayDanhMucTinhThanh";
                String DISTRICT = "LayDanhMucQuanHuyen";
                String COMMUNE = "LayDanhMucPhuongXa";
                String ORGAN = "LayDanhMucCoQuan";
                String COUNTRY = "LayDanhMucQuocGia";
                String NATION = "LayDanhMucDanToc";
                String RELIGION = "LayDanhMucTonGiao";
                String MARITAL_STATUS = "LayDanhMucTinhTrangHonNhan";
                String OBJECT = "LayDanhMucDoiTuong";
                String AREA = "LayDanhMucLinhVuc";
                String LEVEL = "LayDanhMucCapThucHien";
                String LEGAL = "LayDanhMucCanCuPhapLy";
                String PROCEDURE = "LayDanhSachTTHC";
                String FEE = "LayDanhMucLePhi";
            }

            interface DVCQG_SYNC_DOWN {
                String PROCEDURE_DETAIL = "LayThuTuc";
                String QUESTION_DVCQG = "LayDanhSachHoiDapGuiTuDVCQG";
                String QUESTION_ANSWER_DVCQG = "LayDanhSachHoiDapBoCoQuan";
            }

            interface DVCQG_SYNC_UP {
                String ANSWER_DVCQG = "DongBoKetQuaHoiDapGuiTuDVCQG";
                String QUESTION_ANSWER_DVCQG = "DongBoHoiDap";
                String PROBE_DVCQG = "DongBoDanhGia";

            }
        }

        public interface CATEGORY_GROUP {
            interface CODE {
                String GENDER = "GENDER";
                String PROVINCE = "PROVINCE";
                String DISTRICT = "DISTRICT";
                String COMMUNE = "COMMUNE";
                String ORGAN = "ORGAN";
                String COUNTRY = "COUNTRY";
                String NATION = "NATION";
                String RELIGION = "RELIGION";
                String MARITAL_STATUS = "MARITAL_STATUS";
                String OBJECT = "PROCEDURE_OBJECT";
                String TYPE = "PROCEDURE_TYPE";
                String AREA = "PROCEDURE_AREA";
                String LEVEL = "CTH";
                String LEGAL = "LEGAL";
                String PROCEDURE = "DVC_PROCEDURE";
                String FEE = "FEE";
                String HTNHS = "HTNHS";
            }
        }


    }
