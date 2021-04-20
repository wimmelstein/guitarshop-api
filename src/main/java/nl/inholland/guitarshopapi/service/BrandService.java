package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.dao.BrandRepository;
import nl.inholland.guitarshopapi.model.Brand;
import nl.inholland.guitarshopapi.model.Guitar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {

        return (List<Brand>)brandRepository.findAll();
    }

}
