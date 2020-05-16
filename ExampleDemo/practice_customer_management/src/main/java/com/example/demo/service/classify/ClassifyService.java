package com.example.demo.service.classify;

import com.example.demo.model.Classify;

public interface ClassifyService {
    Iterable<Classify> findAllClassify();

    Classify findClassifyById(Long id);

    void saveClassify(Classify classify);

    void deleteClassify(Long id);
}
