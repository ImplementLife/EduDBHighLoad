package com.impllife.service;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.impllife.data.entity.*;
import com.impllife.data.entity.elasticsearch.ProductIndex;
import com.impllife.data.jpa.*;
import com.impllife.service.es.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.*;

import static com.impllife.service.RandomUtils.getRandomElement;

@Service
@Slf4j
public class ILFaker {
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

    @Autowired
    private ProductService productService;

    private final Faker fakerUA = Faker.instance(new Locale("uk", "UA"));
    private final Faker fakerEN = Faker.instance(new Locale("en", "UA"));
    private Date timeServiceStart;

    @PostConstruct
    public void generate() {
        init();
//        generateUsers();
//        generateCategories();
//        generateProducts();
//        generateOrders();
//        generateReview();
        tst();
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, Calendar.JUNE);
        calendar.set(Calendar.DAY_OF_MONTH, 16);

        timeServiceStart = calendar.getTime();
    }

    private void generateCategories() {
        log.info("Generate Categories");

        for (int i = 0; i < 37; i++) {
            Category category = new Category();
            category.setName(fakerUA.funnyName().name());
            category.setDescription(fakerUA.lorem().characters(12, 38));

            categoryRepository.save(category);
        }
    }

    private void generateProducts() {
        log.info("Generate Products");

        List<Category> categories = categoryRepository.findAll();
        for (int i = 0; i < 23; i++) {
            Product product = new Product();
            Commerce commerce = fakerUA.commerce();
            product.setName(commerce.productName());
            String dscr = "Made in: " + fakerUA.country().name() + "\nMade by: " + fakerUA.company().name();
            dscr += "\n\n" + genDscr();

            product.setDescription(dscr);
            product.setPrice(Double.parseDouble(commerce.price().replace(',', '.')));


            product.setCategory(getRandomElement(categories));

            Product save = productRepository.save(product);
            try {
                productService.saveIndex(save);
            } catch (Exception e) {
//                log.error("err", e);
                log.error("se err: {}", save);
                throw e;
            }
        }
    }

    private void generateOrders() {
        log.info("Generate Orders");

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
        log.info("Generate Review");
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
//            if (user.isEmpty()) continue;
            review.setUser(user.get());
            review.setRating(fakerUA.random().nextInt(3, 5));

            reviewRepository.save(review);
        }
    }

    private void generateUsers() {
        log.info("Generate Users");

        for (int i = 0; i < 24542; i++) {
            User person = new User();
            Name name = fakerUA.name();
            person.setFirstName(name.firstName());
            person.setLastName(name.lastName());
            person.setName(name.name());
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
                com.github.javafaker.Address fakerAddress = fakerUA.address();
                address.setStreet(fakerAddress.streetAddress());
                address.setCity(fakerAddress.city());
                address.setState(fakerAddress.stateAbbr());
                address.setZipCode(fakerAddress.zipCode());
                person.getAddresses().add(address);
            }

            userRepository.save(person);
        }
    }

    private String genDscr() {
        Faker faker = new Faker(new Locale("uk"));

        String productName = faker.commerce().productName();
        String material = faker.commerce().material();
        String color = faker.commerce().color();
        String department = faker.commerce().department();
        String price = faker.commerce().price();
        String brand = faker.company().name();
        String feature1 = faker.lorem().sentence();
        String feature2 = faker.lorem().sentence();
        String benefit1 = faker.lorem().sentence();
        String benefit2 = faker.lorem().sentence();

        String productDescription = String.format(
            "Представляємо %s від %s! Цей %s продукт виготовлений з преміального %s і має стильний %s колір. " +
                "Ідеально підходить для %s відділу, цей продукт ідеальний для %s. %s Він має %s. " +
                "Все це може бути вашим всього за %s грн. Відчуйте найкращу якість і стиль з %s.",
            productName, brand, material, color, department, feature1, feature2, benefit1, benefit2, price, productName
        );
        return productDescription;
    }


    private void tst() {
        List<ProductIndex> phone = productService.findByNameContaining("Сша");
        log.info("search");
    }
}
