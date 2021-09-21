package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(1, "Flowers for Algernon", 100, "D. Keyes")};
        Product[] actual = manager.searchBy("D. Keyes");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, "Jane Eyre", 200, "C. Brontë")};
        Product[] actual = manager.searchBy("Jane Eyre");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(3, "IPhone A2403", 300, "IPhone")};
        Product[] actual = manager.searchBy("IPhone A2403");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(4, "Mi 11", 400, "Xiaomi")};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }
}