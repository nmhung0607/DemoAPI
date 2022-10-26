package com.example.demo.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dell on 10/12/2022
 */
@Entity
@Table(name = "NHAN_VIEN")
@Data
public class NhanVien {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NHAN_VIEN_SEQ")
    @SequenceGenerator(sequenceName = "NHAN_VIEN_SEQ", initialValue = 1, allocationSize = 1, name = "NHAN_VIEN_SEQ")
    private long id;

    @Basic
    @Column(name = "TEN")
    private String ten;

    @Basic
    @Column(name = "OLD")
    private String old;

    @Transient
    private Long type;

}
