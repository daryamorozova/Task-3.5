package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "name1", 100, "author1");
    private Book second = new Book(2, "name2", 200, "author2");
    private Smartphone third = new Smartphone(3, "name3", 200, "vendor1");
    private Smartphone forth = new Smartphone(4, "name4", 200, "vendor2");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(forth);
    }

    @Test
    public void shouldSearchBookName() {
        String text = "name1";

        Product[] expected = new Product[]{first};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAuthor() {
        String text = "author2";

        Product[] expected = new Product[]{second};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneName() {
        String text = "name3";

        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneVendor() {
        String text = "vendor2";

        Product[] expected = new Product[]{forth};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

}