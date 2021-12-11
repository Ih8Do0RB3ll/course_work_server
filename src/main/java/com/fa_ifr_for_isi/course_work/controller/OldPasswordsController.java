package com.fa_ifr_for_isi.course_work.controller;

import com.fa_ifr_for_isi.course_work.entity.OldPasswords;
import com.fa_ifr_for_isi.course_work.service.OldPasswordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OldPasswordsController {
    /**
     * Класс контроллера Устаревших паролей(OldPasswordsController)
     * Данный модуль обеспечивает взаимодействе с объектами отчетов в БД и клиентским приложением,
     * оно обеспечивается при помощи методов поиска, обновления и создания нового объекта.
     * Сами эти методы реализованы с помощью аннотаций, указывающих на тип запроса к БД, а также
     * ссылок на таблицы, к которой метод должен подключиться.
     *
     *
     */
    private final OldPasswordsService oldPasswordsService;

    @Autowired
    public OldPasswordsController(OldPasswordsService oldPasswordsService){
        this.oldPasswordsService = oldPasswordsService;
    }
    @PostMapping("/api/oldPasswords")
    public ResponseEntity<?>create(@RequestBody OldPasswords oldPasswords){
        oldPasswordsService.create(oldPasswords);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/oldPasswords")
    public ResponseEntity<List<OldPasswords>> findALL(){
        final List<OldPasswords> oldPasswordsList = oldPasswordsService.findAll();
        return oldPasswordsList != null && !oldPasswordsList.isEmpty()
                ? new ResponseEntity<>(oldPasswordsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/oldPasswords/{id}")
    public ResponseEntity<Optional<OldPasswords>> find(@PathVariable(name = "id")Long id){
        final Optional<OldPasswords> oldPasswords = oldPasswordsService.find(id);
        return oldPasswords!=null
                ? new ResponseEntity<>(oldPasswords, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/oldPasswords/{id}")
    public ResponseEntity<?> updateOldPasswords(@PathVariable(name = "id")Long id, @RequestBody OldPasswords oldPasswordsUpdate){
        return oldPasswordsService.find(id).map(oldPasswords -> {
            oldPasswords.setEmployee(oldPasswordsUpdate.getEmployee());
            oldPasswordsService.update(oldPasswords);
            return new ResponseEntity<>(oldPasswords, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
