package com.example.demo.model;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="DON_VI")
@Data
public class Department {
	@Id
    @Column(name = "DE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DON_VI_SEQ")
    @SequenceGenerator(sequenceName = "DON_VI_SEQ", initialValue = 1, allocationSize = 1, name = "DON_VI_SEQ")
    private long id;
	@Basic
	@Column(name="DE_NAME" , length = 255 , nullable = false)
	private String name;
	@Basic
	@Column(name="ADDRESS",length = 500 , nullable = false)
	private String address;
	
	@Column(name="CODE",length = 255 , nullable = false)
	private long code;
	
	@Column(name="PARENT_ID",length = 10 , nullable = false)
	private long p_id;
	
	@Column(name="DE_PATH")
	private long path;
	
	@Column(name="STATUS",length = 255)
	private long status;
	@Column(name="IS_DELETE")
	private long is_delete;
	@Column(name = "CREATOR_DATE", nullable = true)
	private Date createdDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public long getP_id() {
		return p_id;
	}
	public void setP_id(long p_id) {
		this.p_id = p_id;
	}
	public long getPath() {
		return path;
	}
	public void setPath(long path) {
		this.path = path;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public long getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(long is_delete) {
		this.is_delete = is_delete;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", address=" + address + ", code=" + code + ", p_id=" + p_id
				+ ", path=" + path + ", stt=" + status + ", is_delete=" + is_delete + ", createdDate=" + createdDate + "]";
	}
	
	
	
}
