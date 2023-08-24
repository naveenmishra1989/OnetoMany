package com.example.oneToMany;

import com.example.oneToMany.entity.Mobile;
import com.example.oneToMany.entity.Person;
import com.example.oneToMany.repo.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToManyApplication implements CommandLineRunner {

	private final MobileRepository mobileRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person person = Person.builder().name("naveen").build();
		Mobile mobile = Mobile.builder().mobile("4565764").person(person).build();
		System.out.println(mobileRepository.save(mobile));

		Thread.sleep(6000);
		Mobile mobile1 = mobileRepository.findById(1L).get();
		mobile1.setMobile("7777777");
		System.out.println(mobileRepository.save(mobile1));
	}
}
