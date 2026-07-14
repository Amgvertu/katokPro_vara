package info.prorabka.vara.service;

import info.prorabka.vara.exception.ResourceNotFoundException;
import info.prorabka.vara.repository.RinkRepository;
import info.prorabka.vara.dto.response.RinkResponse;
import info.prorabka.vara.entity.Rink;
import info.prorabka.vara.mapper.RinkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RinkService {

    private final RinkRepository rinkRepository;
    private final RinkMapper rinkMapper;

    public List<RinkResponse> getRinksByCity(Long cityId) {
        return rinkRepository.findByCityId(cityId).stream()
                .map(rinkMapper::toResponse)
                .collect(Collectors.toList());
    }

    public RinkResponse getRinkById(Long id) {
        Rink rink = rinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ЛДС не найден с id: " + id));
        return rinkMapper.toResponse(rink);
    }

    public List<RinkResponse> searchRinks(String query, Long cityId) {
        return rinkRepository.search(query, cityId).stream()
                .map(rinkMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<RinkResponse> getAllRinks() {
        return rinkRepository.findAll().stream()
                .map(rinkMapper::toResponse)
                .collect(Collectors.toList());
    }
}