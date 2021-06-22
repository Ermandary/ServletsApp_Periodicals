package com.ermanadary.dao;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.entity.Periodical;

import java.util.List;

public interface PeriodicalDao {
    List<Periodical> findAllPeriodicals() throws DBException;

    List<Periodical> findPeriodicalsByName(String name) throws DBException;

    Periodical findPeriodicalById(long id) throws DBException;

    boolean addPeriodical(Periodical periodical) throws DBException;

    boolean updatePeriodical(Periodical periodical) throws DBException;

    boolean deletePeriodicalById(long periodicalId) throws DBException;
}
