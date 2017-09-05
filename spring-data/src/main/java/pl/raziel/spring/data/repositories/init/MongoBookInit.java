package pl.raziel.spring.data.repositories.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.data.entities.MongoBook;
import pl.raziel.spring.data.repositories.MongoBookRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Component
public class MongoBookInit implements CommandLineRunner {

    @Autowired
    private MongoBookRepository mongoBookRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.asList(new MongoBook("Title", new Date(), 198, new BigDecimal("197.34"))).stream().forEach(e -> mongoBookRepository.save(e));
    }
}
