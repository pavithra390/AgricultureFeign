package com.example.agriculturefeign.controller;
import com.example.agriculturefeign.Service.Feign;
import com.example.agriculturefeign.entity.Agriculture;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@RestController
public class AgricultureController {
    @Autowired
    Feign feign;
    //injecting feign class
    @PostMapping("/consumer/addingRecord")
    //http://localhost:1992/consumer/addingRecord
    public String addAgriculture(@RequestBody Agriculture a) {
        feign.addAgriculture(a);
        return "Record added Successfully";
    }
    @PostMapping("/consumer/addingAllRecords")
    //http://localhost:1992/consumer/addingAllRecords
    public String addAllAgriculture(@RequestBody Iterable<Agriculture> a) {
        feign.addAllAgriculture(a);
        return "All Records added Successfully";
    }
    @GetMapping("/consumer/gettingRecord/{crop_id}")
    @CircuitBreaker(name="AgricultureFeign",fallbackMethod = "getDummyCropById")
    //http://localhost:1992/consumer/gettingRecord/7
    public ResponseEntity<Optional<Agriculture>> getAgricultureById(@PathVariable("crop_id") int id) {
         Optional<Agriculture> crop=feign.getAgricultureById(id);
        return ResponseEntity.ok(crop);
    }
//    public Optional<Agriculture> getDummyCropById(int id, Throwable throwable)
//    {
//     System.out.println("Fallback method triggered due to: " + throwable.getMessage());
//      return Optional.of(new Agriculture(0, "Fallback crop", "Fertilizer not available",0));
//   }
public ResponseEntity<Optional<Agriculture>> getDummyCropById(int id, Throwable throwable) {
    System.out.println("Fallback method triggered due to: " + throwable.getMessage());

    Agriculture fallbackCrop = new Agriculture(0, "Fallback crop", "Fertilizer not available", 0);
    return ResponseEntity
            .status(HttpStatus.SERVICE_UNAVAILABLE)
            .body(Optional.of(fallbackCrop));
}
//
//    public ResponseEntity<Map<String, String>> getDummyCropById(Integer id, Throwable throwable)
//    {
//        System.out.println("Fallback method triggered due to: " + throwable.getMessage());
//
//        Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("error", "Crop is currently unavailable.");
//        errorResponse.put("message", throwable.getMessage());
//
//        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
//    }

    @GetMapping("/consumer/gettingAllRecords")
    //http://localhost:1992/consumer/gettingAllRecords
    public Iterable<Agriculture> getAllAgricultureRecords() {
        return feign.getAllAgricultureRecords();
    }
    @DeleteMapping("/consumer/deleteRecord/{crop_id}")
    //http://localhost:1992/consumer/deleteRecord
    public String deleteAgriculture(@PathVariable("crop_id") Integer id) {
        feign.deleteAgriculture(id);
        return "Record deleted Successfully";
    }
    @DeleteMapping("/consumer/deletingAllRecords")
    //http://localhost:1992/consumer/deletingAllRecords
    public String deleteAllAgricultureRecords() {
        feign.deleteAllAgricultureRecords();
        return "All records deleted successfully";
    }

}


