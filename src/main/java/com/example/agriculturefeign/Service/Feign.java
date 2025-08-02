package com.example.agriculturefeign.Service;
import com.example.agriculturefeign.entity.Agriculture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name="Agriculture")
public interface Feign {
    @PostMapping("/producer/addingRecord")
    public String addAgriculture(@RequestBody Agriculture a);
    @PostMapping("/producer/addingAllRecords")
    public String addAllAgriculture(@RequestBody Iterable<Agriculture> a);
    @GetMapping("/producer/gettingRecord/{crop_id}")
    public Optional<Agriculture> getAgricultureById(@PathVariable("crop_id") int id);
    @GetMapping("/producer/gettingAllRecords")
    public Iterable<Agriculture> getAllAgricultureRecords();
    @DeleteMapping("/producer/deleteRecord/{crop_id}")
    public String deleteAgriculture(@PathVariable("crop_id") Integer id);
    @DeleteMapping("/producer/deletingAllRecords")
    public String deleteAllAgricultureRecords();
    }
