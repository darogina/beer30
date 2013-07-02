package com.github.darogina.beer30.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.darogina.beer30.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
