package info.prorabka.vara.service;

import info.prorabka.vara.repository.AgreementRepository;
import info.prorabka.vara.entity.Agreement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;

    @Transactional(readOnly = true)
    public Optional<Agreement> getAgreementByType(String type) {
        return agreementRepository.findByType(type);
    }
}