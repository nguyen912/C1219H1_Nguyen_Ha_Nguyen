package com.casestudy.project.service.other_service;

import com.casestudy.project.model.service.OtherService;

public interface OtherServiceService {
    Iterable<OtherService> findAll();

    OtherService save(OtherService otherService);
}
