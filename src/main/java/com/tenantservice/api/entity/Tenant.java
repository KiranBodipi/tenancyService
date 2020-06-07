package com.tenantservice.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tenant")
public class Tenant {
	
	@Id
	@Column(name = "tenant_id")
	private String tenantId;
	
	@NotBlank(message = "Company Name is mandatory")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = "Contact Email is mandatory.")
	@Email(message = "Please enter your email in the correct format.")
	@Column(name = "contact_email")
	private String contactEmail;
	
	@Column(name = "contact_first_name")
	private String contactFirstName;
	
	@Column(name = "contact_last_name")
	private String contactLastName;
	
	@Column(name = "external_id")
	private String externalId;
	
	@Value("${defaultUsername}")
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "zip")
	private String zip;
	@Column(name = "contact_phone")
	private String contactPhone;
	
	@Column(name = "company_email_domain")
	private String companyEmailDomain;
	
	
	public Tenant() {
	}
		
	public Tenant(String tenantId, String companyName, String contactEmail, String contactFirstName,
			String contactLastName, String externalId, String createdBy, LocalDateTime createdDate, String city,
			String country, String zip, String contactPhone, String companyEmailDomain,String state ) {
		this.tenantId = tenantId;
		this.companyName = companyName;
		this.contactEmail = contactEmail;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.externalId = externalId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.contactPhone = contactPhone;
		this.companyEmailDomain = companyEmailDomain;
	}


	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getCompanyEmailDomain() {
		return companyEmailDomain;
	}
	public void setCompanyEmailDomain(String companyEmailDomain) {
		this.companyEmailDomain = companyEmailDomain;
	}
	
}
