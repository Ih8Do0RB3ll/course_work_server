package com.fa_ifr_for_isi.course_work.repo;

import com.fa_ifr_for_isi.course_work.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportsRepo extends JpaRepository<Reports, Long> {
    /**
     * Интерфейс Репозитория сущности Отчёты(ReportsRepo)
     * Данный модуль недобходим для упрощения написания алгоритмов взаимодействия клиента и сервера
     * и включает в себя реальизацию самых простых запросов, что упрощает написание всего кода вцелом
     */

    public List<Reports> findByEmployee_Id(Long id);
}
