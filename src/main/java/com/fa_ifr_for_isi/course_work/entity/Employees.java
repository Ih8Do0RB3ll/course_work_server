package com.fa_ifr_for_isi.course_work.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employees {
    /**
     * Класс сущности Сотрудники(Employees)
     * В данном модуле происходит описание сущности БД и задаются ее параметры
     * вместе со связями с другими сущностями
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Departments department;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Reports> reportsList = new ArrayList<>();

    public void addReport(Reports report){
        report.setEmployee(this);
        this.reportsList.add(report);
    }

    public void removeReport(Reports report){
        this.reportsList.remove(report);
    }
}
