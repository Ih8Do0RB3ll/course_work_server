package com.fa_ifr_for_isi.course_work.service;

import com.fa_ifr_for_isi.course_work.entity.Employees;
import com.fa_ifr_for_isi.course_work.repo.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    /**
     * Модуль сервиса сущности Сотрудники(EmployeesService)
     * Здесь реализованы обращения к стандартным запросам сервера
     */

    @Autowired
    private EmployeesRepo employeesRepo;

    public void create(Employees employees){employeesRepo.save(employees);}

    public void update(Employees employees){employeesRepo.save(employees);}

    public void delete(Employees employees){employeesRepo.delete(employees);}

    public List<Employees> findAll(){return employeesRepo.findAll();}

    public Optional<Employees> find(Long id){return employeesRepo.findById(id);}

    public Optional<Employees> findByUsername(String username){ return employeesRepo.findByUsername(username);}
}
