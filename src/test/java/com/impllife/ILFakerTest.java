package com.impllife;

import com.impllife.data.jpa.OrderRepository;
import com.impllife.data.jpa.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Boot.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ILFakerTest {
    private static final Logger LOG = LoggerFactory.getLogger(ILFakerTest.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findById() {
        orderRepository.findById(35L);
    }

    @Test
    public void findByIdEager() {
        userRepository.findByIdEager(35L);
    }

    @Test
    public void findAllWithEG() {
        userRepository.findAllWithEG(PageRequest.of(0, 20));
    }

    @Test
    public void findAllEagerSlice() {
        userRepository.findAllEagerSlice(PageRequest.of(0, 20));
    }

    @Test
    public void findAllEagerOffsetLimit() {
        userRepository.findAllEager(0, 20);
    }

    @Test
    public void findAllWithEGP2() {
        userRepository.findAllWithEGP2(PageRequest.of(0, 20));
    }

    @Test
    public void findAllWithEGOL() {
        userRepository.findAllWithEGOL(0, 20);
    }

}
