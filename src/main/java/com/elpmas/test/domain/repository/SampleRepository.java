package com.elpmas.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elpmas.test.domain.entity.SampleEntity;
public interface SampleRepository extends JpaRepository<SampleEntity,Integer>{

}
