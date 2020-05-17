package nl.inholland.guitarshopapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuitarTest {

  private Guitar guitar;

  @BeforeEach
  public void Setup() {
    guitar = new Guitar();
  }
  @Test
  public void createGuitarShouldNotBeNull() {
    assertNotNull(guitar);
  }

  @Test
  public void settingPriceBelowZeroShouldThrowException() {
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> guitar.setPrice(-1));
    assertEquals("Price cannot be below zero", exception.getMessage());
  }
}