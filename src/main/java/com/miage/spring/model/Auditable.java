package com.miage.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Auditable is an abstract class for Post, Topic and Project (HasPermission
 * Classes) It is used to register the creation and modification of tese
 * entities
 */
@Data
@Accessors(chain = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable implements Serializable {

	@CreatedBy
	@ManyToOne
	private User createdBy;

	@LastModifiedBy
	@ManyToOne
	private User modifiesBy;

	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date updatedAt;
}
