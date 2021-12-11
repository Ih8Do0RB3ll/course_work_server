package com.fa_ifr_for_isi.course_work.controller;

import com.fa_ifr_for_isi.course_work.entity.Departments;
import com.fa_ifr_for_isi.course_work.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentsController {
    /**
     * Класс контроллера Департаментов(DepartmentsController)
     * Данный модуль обеспечивает взаимодействе с объектами отчетов в БД и клиентским приложением,
     * оно обеспечивается при помощи методов поиска, обновления и создания нового объекта.
     * Сами эти методы реализованы с помощью аннотаций, указывающих на тип запроса к БД, а также
     * ссылок на таблицы, к которой метод должен подключиться.
     *
     *
     */
    private final DepartmentsService departmentsService;

    @Autowired
    public DepartmentsController(DepartmentsService departmentsService){
        this.departmentsService = departmentsService;
    }
    @PostMapping("/api/departments")
    public ResponseEntity<?>create(@RequestBody Departments departments){
        departmentsService.create(departments);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/departments")
    public ResponseEntity<List<Departments>> findALL(){
        final List<Departments> departmentsList = departmentsService.findAll();
        return departmentsList != null && !departmentsList.isEmpty()
                ? new ResponseEntity<>(departmentsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/departments/{id}")
    public ResponseEntity<Optional<Departments>> find(@PathVariable(name = "id")Long id){
        final Optional<Departments> departments = departmentsService.find(id);
        return departments!=null
                ? new ResponseEntity<>(departments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/departments/{id}")
    public ResponseEntity<?> updateDepartments(@PathVariable(name = "id")Long id, @RequestBody Departments departmentsUpdate){
        return departmentsService.find(id).map(departments -> {
            departments.setDepartment_name(departmentsUpdate.getDepartment_name());
            departmentsService.update(departments);
            return new ResponseEntity<>(departments, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @DeleteMapping("/api/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") Long id) {
        return departmentsService.find(id).map(departments -> {
            departmentsService.delete(departments);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
