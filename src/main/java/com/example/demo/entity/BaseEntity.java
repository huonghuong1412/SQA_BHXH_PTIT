package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@SequenceGenerator(name = "id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	private Long id;

//	@Column(name="created_by")
//	private String createdBy;

//	@Column(name = "created_date")
//	private String createdDate;
//
//	@Column(name="modified_by")
//	private String modifiedBy;
//
//	@Column(name="modified_date")
//	private Date modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public String getCreatedDate() {
//		return createdDate;
//	}
//
////
//	public void setCreatedDate(String createdDate) {
//		this.createdDate = new Timestamp(new Date().getTime()).toString();
//	}
//
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}

}
