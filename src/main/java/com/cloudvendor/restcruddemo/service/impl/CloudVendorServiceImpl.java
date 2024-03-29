package com.cloudvendor.restcruddemo.service.impl;

import com.cloudvendor.restcruddemo.exception.CloudVendorNotFoundException;
import com.cloudvendor.restcruddemo.model.CloudVendor;
import com.cloudvendor.restcruddemo.repository.CloudVendorRepository;
import com.cloudvendor.restcruddemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Requested Cloud Vendor doesn't exist in our database.");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }
    @Override
    public List<CloudVendor> getByCloudVendorName(String cloudVendorName) {
        if(cloudVendorRepository.findByVendorName(cloudVendorName).isEmpty()) {
            throw new CloudVendorNotFoundException("Requested Cloud Vendor doesn't exist in our database.");
        }

        return cloudVendorRepository.findByVendorName(cloudVendorName);
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
