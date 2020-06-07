package com.tenantservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tenantservice.api.entity.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, String> {
	
	@Query(value = "update tenant set contact_email = :contactEmail where tenant_id = :tenantId", nativeQuery = true)
	public Integer updateEmail(@Param("contactEmail") String tenantEmail, @Param("tenantId") String tenantId );
}
