package com.cloudvendor.restcruddemo.repository;

import com.cloudvendor.restcruddemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
