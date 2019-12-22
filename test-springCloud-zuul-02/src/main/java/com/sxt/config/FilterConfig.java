package com.sxt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sxt.filter.PermissionFilter;

@Configuration
public class FilterConfig {
	@Bean
	public PermissionFilter getFilter() {
		return new PermissionFilter();
	}
}
