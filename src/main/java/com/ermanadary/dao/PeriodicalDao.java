package com.ermanadary.dao;

import com.ermanadary.entity.Periodical;

import java.util.List;

public interface PeriodicalDao {
    List<Periodical> findAllPeriodicals();

    List<Periodical> findPeriodicalsByName(String name);

    Periodical findPeriodicalById(long id);

    boolean addPeriodical(Periodical periodical);

    boolean updatePeriodical(Periodical periodical);

    boolean deletePeriodicalById(long periodicalId);
}
