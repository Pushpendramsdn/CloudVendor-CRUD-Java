package com.cloudvendor.restcruddemo.controller;

import com.cloudvendor.restcruddemo.model.CloudVendor;
import com.cloudvendor.restcruddemo.response.ResponseHandler;
import com.cloudvendor.restcruddemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler
                .responseBuilder(
                        "Requested details fetched successfully.",
                        HttpStatus.OK,
                        cloudVendorService.getCloudVendor(vendorId)
                );
    }


    @GetMapping()
    public ResponseEntity<Object> getAllCloudVendorDetails() {
        return ResponseHandler
                .responseBuilder(
                        "Requested details fetched successfully.",
                        HttpStatus.OK,
                        cloudVendorService.getAllCloudVendor()
                );
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully.";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated successfully.";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
       cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully.";
    }
}

