package com.tenantservice.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tenantservice.api.entity.Tenant;
import com.tenantservice.api.exception.NoTenantsException;
import com.tenantservice.api.exception.TenantIdCannotBeModifiedException;
import com.tenantservice.api.exception.TenantNotFoundException;
import com.tenantservice.api.service.TenantService;

@RestController
@RequestMapping("/ets")
@Validated
public class TenantController {
	String defaultUserName = "anonymous";
	
	@Autowired
	TenantService tenantService;
	
	Logger logger = Logger.getLogger(TenantController.class);
	
	@GetMapping("/tenants")
	public List<Tenant> getTenants() throws NoTenantsException {
		List<Tenant> tenants = tenantService.getTenants();
		if(tenants.isEmpty()) {
			throw new NoTenantsException("Currently there are no tenants exists in the Database.");
		}
		return tenants;
	}
	
	@GetMapping("/tenants/{tenantId}")
	public Tenant getTenant(@PathVariable String tenantId) throws TenantNotFoundException {
		return tenantService.getTenant(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant: "+tenantId+" not found in the Database."));
		}
	
	@GetMapping("/tenants/page")
	public Page<Tenant> getTenantsPagewise( ){
		Pageable pageable = PageRequest.of(1, 5, Direction.ASC);
		return tenantService.getTenantsPagewise(pageable);
	}
	
	@PostMapping("/tenants")
	public Tenant createTenant(@Valid @RequestBody Tenant tenant) throws DataIntegrityViolationException {
		tenant.setCreatedBy(defaultUserName);
		tenant.setCreatedDate(LocalDateTime.now());
		return tenantService.createTenant(tenant);
	}
	
	@PutMapping("/tenants/{tenantId}")
	public Tenant updateTenant(@PathVariable(required = true) String tenantId,@Valid @RequestBody Tenant newTenant) throws TenantNotFoundException, TenantIdCannotBeModifiedException {
		if(newTenant.getTenantId().equals(tenantId)) {
			return tenantService.getTenant(tenantId)
			      .map(tenant -> {
			    	  tenant.setContactFirstName(newTenant.getContactFirstName());
			    	  tenant.setContactLastName(newTenant.getContactLastName());
			    	  tenant.setContactEmail(newTenant.getContactEmail());
			    	  tenant.setContactPhone(newTenant.getContactPhone());
			    	  tenant.setCity(newTenant.getCity());
			    	  tenant.setState(newTenant.getState());
			    	  tenant.setCountry(newTenant.getCountry());
			    	  tenant.setCreatedDate(LocalDateTime.now());
			    	  tenant.setCreatedBy(defaultUserName);
			    	  tenant.setZip(newTenant.getZip());
			    	  tenant.setExternalId(newTenant.getExternalId());
			        return tenantService.updateTenant(tenant);
			      })
			      .orElseThrow( () -> new TenantNotFoundException("Tenant : "+tenantId+" not found in the Database."));
		}else {
			 throw new TenantIdCannotBeModifiedException("Tenant Id/company name cannot be changed.");
		}
	}
	
	@PatchMapping("/tenants/{tenantId}")
	public Tenant updateEmail(@PathVariable String tenantId, @Email @RequestParam String contactEmail) throws TenantNotFoundException,ConstraintViolationException{
		
		return tenantService.getTenant(tenantId)
				.map(tenant -> { 
					tenant.setContactEmail(contactEmail);
				return tenantService.updateTenant(tenant);
			}).orElseThrow(() -> new TenantNotFoundException("Tenant "+tenantId+" not found in the Database."));
	}
}
 