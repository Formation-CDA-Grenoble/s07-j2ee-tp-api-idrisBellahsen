package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    // Injection de dépendance
    @Autowired
    private BrandRepository brandRepository;
    
    @GetMapping("")
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Brand createBrand(@Valid @RequestBody Brand brand) {
        return brandRepository.save(brand);
    }

    @PutMapping("/{id}")
    public Brand updateBrand(@Valid @RequestBody Brand newBrand) {
        Brand brand = this.fetchBrand(newBrand.getId());
        brand.setName(newBrand.getName());
        brand.setCountry(newBrand.getCountry());
        
        return brandRepository.save(brand);
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable(value = "id") Long brandId) {
        return this.fetchBrand(brandId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable(value = "id") Long brandId) {
        Brand brand = this.fetchBrand(brandId);
        brandRepository.delete(brand);
    }

    public Brand fetchBrand(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand not found")
        );
        return brand;
    }
}
