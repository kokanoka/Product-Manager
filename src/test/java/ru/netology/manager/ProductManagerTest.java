package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product first =  new Book(1, "Flowers for Algernon", 100, "D. Keyes");
    private Product second = new Book(2, "Jane Eyre", 200, "C. Brontë");
    private Product third = new Smartphone(3, "IPhone A2403", 300, "IPhone");
    private Product fourth = new Smartphone(4, "Mi 11", 400, "Xiaomi");
    private Product fifth = new Smartphone(5, "IPhone A2221", 500, "IPhone");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }


    @Test
    void shouldSearchByAuthor() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("D. Keyes");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Jane Eyre");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("IPhone A2403");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturerTwoProducts() {
        Product[] expected = new Product[]{third, fifth};
        Product[] actual = manager.searchBy("IPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturerNoProducts() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
}