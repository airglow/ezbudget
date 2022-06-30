package ir.airglow.ezbudget;

import ir.airglow.ezbudget.entity.Province;
import ir.airglow.ezbudget.repository.ProvinceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer implements CommandLineRunner {

    private final ProvinceRepository provinceRepository;

    public Initializer(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Province> provinces = new ArrayList<>();
        provinces.add(Province.builder().code("1").name("Tehran").build());
        provinces.add(Province.builder().code("2").name("Esfahan").build());
        provinces.add(Province.builder().code("3").name("Mashhad").build());
        provinces.add(Province.builder().code("4").name("Shiraz").build());
        provinces.add(Province.builder().code("5").name("Tabriz").build());

        provinceRepository.saveAll(provinces);

        provinceRepository.findAll().forEach(System.out::println);
    }
}
