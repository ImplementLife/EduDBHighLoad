package com.impllife.service;

import com.github.javafaker.Faker;
import com.impllife.data.entity.*;
import com.impllife.data.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
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

    private final Faker fakerUA = Faker.instance(new Locale("uk", "UA"));
    private final Faker fakerEN = Faker.instance(new Locale("en", "UA"));
    private Date timeServiceStart;

    @PostConstruct
    public void generate() {
        init();
        generateUsers();
        //generateCategories();
        //generateProducts();
        generateOrders();
        generateReview();
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, Calendar.JUNE);
        calendar.set(Calendar.DAY_OF_MONTH, 16);

        timeServiceStart = calendar.getTime();
    }

    private void generateCategories() {
        LOG.info("Generate Categories");

        for (int i = 0; i < 37; i++) {
            Category category = new Category();
            category.setName(fakerUA.funnyName().name());
            category.setDescription(fakerUA.lorem().characters(12, 38));

            categoryRepository.save(category);
        }
    }

    private void generateProducts() {
        LOG.info("Generate Products");

        List<Category> categories = categoryRepository.findAll();
        for (int i = 0; i < 238; i++) {
            Product product = new Product();
            product.setName(fakerUA.commerce().productName());
            product.setDescription("Made in: " + fakerUA.country().name() + "\nMade by: " + fakerUA.company().name());
            product.setPrice(Double.parseDouble(fakerUA.commerce().price().replace(',', '.')));

            product.setCategory(getRandomElement(categories));

            productRepository.save(product);
        }
    }

    private void generateOrders() {
        LOG.info("Generate Orders");

        List<User> users = userRepository.findAll();
        List<Product> products = productRepository.findAll();

        for (User user : users) {
            int countOrders = fakerUA.random().nextInt(1, 4);
            if (fakerUA.random().nextInt(0, 10) > 8) {
                countOrders += fakerUA.random().nextInt(3, 14);
            }
            for (int i = 0; i < countOrders; i++) {
                Order order = new Order();
                order.setCustomer(user);

                User customer = order.getCustomer();
                order.setAddress(getRandomElement(customer.getAddresses()));
                order.setDateCreate(fakerUA.date().between(timeServiceStart, new Date()));
                order.setDateLastUpdateStatus(order.getDateCreate());
                order.setStatus(getRandomElement(OrderStatus.values()));

                int countProducts = fakerUA.random().nextInt(1, 7);
                for (int j = 0; j < countProducts; j++) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setQuantity(fakerUA.random().nextInt(1, 20));
                    Product product = getRandomElement(products);
                    orderItem.setProduct(product);
                    orderItem.setPrice(Double.parseDouble(String.format("%.2f", product.getPrice() * orderItem.getQuantity()).replace(",", ".")));

                    if (order.getItems().add(orderItem)) {
                        order.setPrice(Double.parseDouble(String.format("%.2f", order.getPrice() + orderItem.getPrice()).replace(",", ".")));
                    }
                    orderItem.setOrder(order);
                }

                orderRepository.save(order);
            }
        }
    }

    private void generateReview() {
        LOG.info("Generate Review");
        List<Product> products = productRepository.findAll();
        long orders = orderRepository.count();
        long users = userRepository.count();
        int count = fakerUA.random().nextInt(3, (int) orders);
        for (int i = 0; i < count; i++) {
            Review review = new Review();

            review.setContent(fakerUA.lorem().paragraph(fakerUA.random().nextInt(20, 53)));
            review.setProduct(getRandomElement(products));
            int id = fakerUA.random().nextInt(0, (int) users);
            Optional<User> user = userRepository.findById((long) id);
            if (user.isEmpty()) continue;
            review.setUser(user.get());
            review.setRating(fakerUA.random().nextInt(3, 5));

            reviewRepository.save(review);
        }
    }

    private void generateUsers() {
        LOG.info("Generate Users");

        for (int i = 0; i < 24542; i++) {
            User person = new User();
            person.setFirstName(fakerUA.name().firstName());
            person.setLastName(fakerUA.name().lastName());
            person.setName(fakerUA.name().name());
            person.setPhone(fakerUA.phoneNumber().phoneNumber());
            person.setEmail(fakerEN.internet().emailAddress());

            person.setDateCreate(fakerUA.date().between(timeServiceStart, new Date()));
            person.setDateLastUpdateData(fakerUA.date().between(person.getDateCreate(), new Date()));

            if (fakerUA.random().nextBoolean()) {
                person.setTwoFactorAuthTypeEnable(true);
                person.setTwoFactorAuthType(getRandomElement(TwoFactorAuthType.values()));
            }

            person.setAddresses(new HashSet<>());

            for (int j = 0; j < fakerUA.random().nextInt(1, 2); j++) {
                Address address = new Address();
                address.setStreet(fakerUA.address().streetAddress());
                address.setCity(fakerUA.address().city());
                address.setState(fakerUA.address().stateAbbr());
                address.setZipCode(fakerUA.address().zipCode());
                person.getAddresses().add(address);
            }

            userRepository.save(person);
        }
    }

}
