package ir.airglow.ezbudget.service;

import ir.airglow.ezbudget.dto.ProvinceDto;
import ir.airglow.ezbudget.entity.Province;
import ir.airglow.ezbudget.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceService {
	
	private final ProvinceRepository provinceRepository;
	
	public ProvinceService(ProvinceRepository provinceRepository) {
		this.provinceRepository = provinceRepository;
	}
	
	public List<ProvinceDto> findAll() {
		
		Iterable<Province> provincesIterable = provinceRepository.findAll();
		
		List<ProvinceDto> provinces = new ArrayList<>();
		
		provincesIterable.forEach(p -> provinces.add(ProvinceDto.entityToDto(p)));
		
		return provinces;
	}
	
	public ProvinceDto findById(Long id) {

		Province province = provinceRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		return ProvinceDto.entityToDto(province);
	}

	public Long save(ProvinceDto provinceDto) {

		Province province = ProvinceDto.dtoToEntity(provinceDto);

		provinceRepository.save(province);

		return province.getId();
	}

	public void update(Long id, ProvinceDto provinceDto) {

		// Check existence
		provinceRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		Province province = ProvinceDto.dtoToEntity(provinceDto);
		province.setId(id);
		
		provinceRepository.save(province);
	}

	public void delete(Long id) {

		// Check existence
		provinceRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		provinceRepository.deleteById(id);
	}
	
}
