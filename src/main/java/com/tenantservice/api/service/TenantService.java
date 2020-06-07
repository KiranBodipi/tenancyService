package com.tenantservice.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tenantservice.api.entity.Tenant;
import com.tenantservice.api.repository.TenantRepository;

@Service
public class TenantService {
	
	@Autowired
	TenantRepository tenantRepository;
	public List<Tenant> getTenants(){
		return tenantRepository.findAll();
	}
	
	public Optional<Tenant> getTenant(String tenantId) {
		return tenantRepository.findById(tenantId);
	}

	
	public Tenant createTenant(Tenant tenant) {
		return tenantRepository.save(tenant);
	}
	
	public Tenant updateTenant(Tenant tenant) {
		return tenantRepository.save(tenant);
	}
	
	public Integer updateEmail(String tenantId, String contactEmail) {
		return tenantRepository.updateEmail(tenantId,contactEmail);
	}
	
	public Page<Tenant> getTenantsPagewise(Pageable pageable){
		return tenantRepository.findAll(pageable);
		
	}
}
