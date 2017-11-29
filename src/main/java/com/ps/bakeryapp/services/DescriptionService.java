package com.ps.bakeryapp.services;

import com.ps.bakeryapp.models.Description;

public interface DescriptionService {
    Description findDescriptionById(Long id);
    void saveDescription(Description descriptionToSave);
}
