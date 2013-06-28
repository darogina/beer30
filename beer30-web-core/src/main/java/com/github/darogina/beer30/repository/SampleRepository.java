package com.github.darogina.beer30.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.darogina.beer30.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
