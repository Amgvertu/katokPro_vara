package info.prorabka.vara.service;

import info.prorabka.vara.repository.CountryRepository;
import info.prorabka.vara.dto.response.CountryResponse;
import info.prorabka.vara.dto.response.CountrySimpleResponse;
import info.prorabka.vara.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(countryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<CountrySimpleResponse> getSimpleCountries() {
        return countryRepository.findAll().stream()
                .map(country -> new CountrySimpleResponse(
                        country.getId(),
                        country.getName(),
                        country.getCode()))
                .collect(Collectors.toList());
    }
}
