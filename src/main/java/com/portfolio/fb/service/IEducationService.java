package com.portfolio.fb.service;

import com.portfolio.fb.model.Education;

import java.util.List;

public interface IEducationService {
    List<Education> getEducations();

    Education addEducation(Education edu);

    Education getEducationById(Long id);

    void deleteEducationById(Long id);

    Education updateEducation(Education edu);
}
