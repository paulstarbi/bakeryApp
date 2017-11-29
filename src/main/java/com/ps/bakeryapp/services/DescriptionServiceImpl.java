package com.ps.bakeryapp.services;

import com.ps.bakeryapp.models.Description;
import com.ps.bakeryapp.repositories.DescriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DescriptionServiceImpl implements DescriptionService {

    private DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public Description findDescriptionById(Long id) {
        Optional<Description> descriptionOptional = descriptionRepository.findById(id);

        return descriptionOptional.orElse(new Description("Not Found"));
    }

    @Override
    public void saveDescription(Description descriptionToSave) {
        Optional<Description> description = descriptionRepository.findById(descriptionToSave.getId());

        if(!description.isPresent()) {
            descriptionRepository.save(descriptionToSave);
        } else  {
            System.out.println("Already exist");
//            log.info("Description exist");
        }
    }
}