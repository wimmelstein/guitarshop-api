package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.dao.BrandRepository;
import nl.inholland.guitarshopapi.dao.GuitarRepository;
import nl.inholland.guitarshopapi.dao.StockRepository;
import nl.inholland.guitarshopapi.model.Brand;
import nl.inholland.guitarshopapi.model.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class GuitarService {

  @Autowired
  private GuitarRepository guitarRepository;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private BrandRepository brandRepository;

  public GuitarService() {
  }

  public List<Guitar> getAllGuitars() {
    return (List<Guitar>) guitarRepository.findAll();
  }

  public Guitar getGuitarById(long id) {
    return guitarRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public void addGuitar(Guitar guitar) {
    Brand brand = brandRepository.findBrandByName(guitar.getBrand().getName());
    if (Objects.isNull(brand)) {
      throw new EntityNotFoundException();
    }
    guitar.setBrand(brand);
    guitarRepository.save(guitar);
    System.out.println(guitar);
  }

  public int valueByGuitarId(long id) {
    return stockRepository.getStockValueByGuitarId(id);
  }

  public List<Guitar> getGuitarsByMinimumPrice(double minimum) {
    return guitarRepository.getAllByPriceGreaterThanEqualOrderById(minimum);
  }
}
