package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

    public Brand getBrandById(long id) {
        return brandRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

}
