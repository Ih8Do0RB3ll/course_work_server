package com.fa_ifr_for_isi.course_work.service;

import com.fa_ifr_for_isi.course_work.entity.DangerLevels;
import com.fa_ifr_for_isi.course_work.repo.DangerLevelsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangerLevelsService {
    /**
     * Модуль сервиса сущности Степени угроз(DangerLevelService)
     * Здесь реализованы обращения к стандартным запросам сервера
     */
    @Autowired
    private DangerLevelsRepo dangerLevelsRepo;

    public void create(DangerLevels dangerLevels){dangerLevelsRepo.save(dangerLevels);}

    public void update(DangerLevels dangerLevels){dangerLevelsRepo.save(dangerLevels);}

    public void delete(DangerLevels dangerLevels){dangerLevelsRepo.delete(dangerLevels);}

    public List<DangerLevels> findAll(){return dangerLevelsRepo.findAll();}

    public Optional<DangerLevels> find(Long id){return dangerLevelsRepo.findById(id);}
}
