package com.impllife.service;

import com.github.javafaker.Faker;
import com.impllife.data.entity.*;
import com.impllife.data.jpa.*;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

import static com.impllife.service.RandomUtils.getRandomElement;

@Service
public class ILFaker {
    private static final Logger LOG = LoggerFactory.getLogger(ILFaker.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private final Faker faker = Faker.instance(new Locale("uk", "UA"));

    @PostConstruct
    public void generate() {
        //generateUsers();
        //generateCategories();
        //generateProducts();
        generateOrders();
        generateReview();
    }

    private void generateCategories() {
        LOG.info("Generate Categories");

        for (int i = 0; i < 37; i++) {
            Category category = new Category();
            category.setName(faker.funnyName().name());
            category.setDescription(faker.lorem().characters(12, 38));

            categoryRepository.save(category);
        }
    }

    private void generateProducts() {
        LOG.info("Generate Products");

        List<Category> categories = categoryRepository.findAll();
        for (int i = 0; i < 174; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setDescription("Made in: " + faker.country().name() + "\nMade by: " + faker.company().name());
            product.setPrice(Double.parseDouble(faker.commerce().price().replace(',', '.')));

            product.setCategory(getRandomElement(categories));

            productRepository.save(product);
        }
    }

    private void generateOrders() {
        LOG.info("Generate Orders");

        List<User> users = userRepository.findAll();
        List<Product> products = productRepository.findAll();

        for (int i = 0; i < 350; i++) {
            Order order = new Order();
            order.setCustomer(getRandomElement(users));

            User customer = order.getCustomer();
            //Hibernate.initialize(customer.getAddresses());
            order.setAddress(getRandomElement(customer.getAddresses()));
            order.setDateCreate(faker.date().between(new Date(2003), new Date()));
            order.setDateLastUpdateStatus(order.getDateCreate());

            for (int j = 0; j < faker.random().nextInt(1, 4); j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(faker.random().nextInt(1, 12));
                orderItem.setProduct(getRandomElement(products));
                orderItem.setPrice(orderItem.getPrice() * orderItem.getQuantity());

                order.getItems().add(orderItem);
            }

            orderRepository.save(order);
        }
    }

    private void generateReview() {
        LOG.info("Generate Review");

        List<Order> all = orderRepository.findAll();
        for (int i = 0; i < faker.random().nextInt(3, all.size()); i++) {
            Review review = new Review();
            Order order = all.get(i);

            Set<OrderItem> items = order.getItems();
            if (items.size() == 0) continue;
            OrderItem item = getRandomElement(items);

            review.setContent(faker.lorem().characters(9, 53));
            review.setProduct(item.getProduct());
            review.setUser(item.getOrder().getCustomer());
            review.setRating(faker.random().nextInt(1, 6));

            reviewRepository.save(review);
        }
    }

    private void generateUsers() {
        LOG.info("Generate Users");

        for (int i = 0; i < 1000; i++) {
            User person = new User();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setName(faker.name().name());
            person.setPhone(faker.phoneNumber().phoneNumber());
            person.setEmail(faker.name().username());

            person.setDateCreate(faker.date().between(new Date(2003), new Date()));
            person.setDateLastUpdateData(faker.date().between(person.getDateCreate(), new Date()));

            if (faker.random().nextBoolean()) {
                person.setTwoFactorAuthTypeEnable(true);
                person.setTwoFactorAuthType(getRandomElement(TwoFactorAuthType.values()));
            }

            person.setAddresses(new HashSet<>());

            for (int j = 0; j < faker.random().nextInt(1, 4); j++) {
                Address address = new Address();
                address.setStreet(faker.address().streetAddress());
                address.setCity(faker.address().city());
                address.setState(faker.address().stateAbbr());
                address.setZipCode(faker.address().zipCode());
                person.getAddresses().add(address);
            }

            userRepository.save(person);
        }
    }

}
