package com.example.oneToMany.repo;

import com.example.oneToMany.entity.Mobile;
import com.example.oneToMany.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MobileRepositoryTest {

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSave() throws Exception{
        Person person = Person.builder().name("naveen").build();
        Mobile mobile = Mobile.builder().mobile("4565764").build();
        person.addProduct(mobile);
        Person save = personRepository.save(person);
        System.out.println(save);
        Thread.sleep(5000);
       Mobile byMobile = mobileRepository.findById(4L).get();
        byMobile.setMobile("777777777");
        Mobile save1 = mobileRepository.save(byMobile);
        System.out.println(save);

    }

}