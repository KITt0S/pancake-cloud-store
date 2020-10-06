package pancakes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pancakes.dao.PancakeRepository;
import pancakes.dao.SauceRepository;

@SpringBootApplication
public class PancakeApplication
{
    public static void main( String[] args )
    {

        SpringApplication.run( PancakeApplication.class, args );
    }

    @Bean
    public CommandLineRunner loadCommand(PancakeRepository pancakeRepo, SauceRepository sauceRepo ) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                pancakeRepo.save(  new Pancake( "Strawberry pancake" ) );
                pancakeRepo.save(  new Pancake( "Peach pancake" ) );

                sauceRepo.save( new Sauce( "Garlic sauce" ) );
                sauceRepo.save( new Sauce( "Cherry sauce" ) );
            }
        };
    }
}
