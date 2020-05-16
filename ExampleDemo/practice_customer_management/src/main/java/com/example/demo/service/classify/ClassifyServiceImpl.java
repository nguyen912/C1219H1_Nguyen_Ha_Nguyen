package com.example.demo.service.classify;

import com.example.demo.model.Classify;
import com.example.demo.repository.ClassifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    private ClassifyRepository classifyRepository;

    @Override
    public Iterable<Classify> findAllClassify() {
        return classifyRepository.findAll();
    }

    @Override
    public Classify findClassifyById(Long id) {
        return classifyRepository.findById(id).orElse(null);
    }

    @Override
    public void saveClassify(Classify classify) {
        classifyRepository.save(classify);
    }

    @Override
    public void deleteClassify(Long id) {
        classifyRepository.deleteById(id);
    }
}
