package com.tenantservice.api.utilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

public class LocalDateTimeConverter implements AttributeConverter<Timestamp, LocalDateTime>{
		 
	@Override
	 public LocalDateTime convertToDatabaseColumn(Timestamp attribute) {
	  return attribute != null ? attribute.toLocalDateTime() : null;
	 }

	 @Override
	 public Timestamp convertToEntityAttribute(LocalDateTime dateTime) {
	  return dateTime != null ? Timestamp.valueOf(dateTime) : null;
	 }
}
