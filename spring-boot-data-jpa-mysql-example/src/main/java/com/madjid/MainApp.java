package com.madjid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.madjid.model.Book;
import com.madjid.repository.BookRepository;


@SpringBootApplication
public class MainApp implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MainApp.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		log.info("Start application");
		
		bookRepository.save(new Book("JAVA"));
		bookRepository.save(new Book("PHP"));
		bookRepository.save(new Book("C++"));
		
		log.info("Call findAll");
		bookRepository.findAll().forEach(x -> System.out.println(x));
		
		log.info("Call findById(1L)");
		bookRepository.findById(1L).ifPresent(x -> System.out.println(x));
		
		log.info("Call findByName(PHP)");
		bookRepository.findByName("PHP").forEach(x -> System.out.println(x));
	}

}
