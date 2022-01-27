package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book book1 = new Book(1, "Core Java", 500, "Smart Guy", 100, 2022);
  private Book book2 = new Book(2, "Некрономикон", 1000, "Лавкрафт", 1000, 1961);

  @BeforeEach
  public void setUp() {
    repository.save(book1);
    repository.save(book2);
  }

  @Test
  public void shouldRemoveById() {
    repository.removeById(2);

    Product[] expected = new Product[]{book1};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldThrowNotFoundException() {

    Assertions.assertThrows(NotFoundException.class, ()->{repository.removeById(3);});
  }
}
