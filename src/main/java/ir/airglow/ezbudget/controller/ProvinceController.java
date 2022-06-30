package ir.airglow.ezbudget.controller;

import ir.airglow.ezbudget.dto.ProvinceDto;
import ir.airglow.ezbudget.service.ProvinceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

	private final ProvinceService provinceService;
	
	public ProvinceController(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}

    @GetMapping
    public List<ProvinceDto> index() {

        return provinceService.findAll();
    }

    @GetMapping("/{id}")
    public ProvinceDto show(@PathVariable("id") Long id) {

        return provinceService.findById(id);
    }

    @PostMapping
    public Long store(@RequestBody ProvinceDto province) {

        Long provinceId = provinceService.save(province);

        log.info("Insert new province: " + provinceId);

        return provinceId;
    }

    @PutMapping("/{id}")
    public ProvinceDto update(@PathVariable("id") Long id, @RequestBody ProvinceDto province) {
    	
    	provinceService.update(id, province);
    	
    	log.info("Update province: " + id);

        return province;
    }

    @DeleteMapping("/{id}")
    public Long destroy(@PathVariable("id") Long id) {

        provinceService.delete(id);

        return id;
    }

}
