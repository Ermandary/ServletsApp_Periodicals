package com.ermanadary.dao.impl.mysql;

import com.ermanadary.dao.DBManager;
import com.ermanadary.dao.PeriodicalDao;
import com.ermanadary.entity.Periodical;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MySqlPeriodicalDao implements PeriodicalDao {

    private static final String INSERT_PERIODICAL = "INSERT INTO periodicals VALUES(DEFAULT, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PERIODICAL = "UPDATE periodicals SET publisher=?, frequency=?, periodical_type=?, periodical_name=?, periodical_price=?, periodical_description=? WHERE periodical_id=?";
    private static final String DELETE_PERIODICAL_BY_ID = "DELETE from periodicals WHERE periodical_id=?";
    private static final String FIND_ALL_PERIODICALS = "SELECT * FROM periodicals";
    private static final String FIND_PERIODICAL_BY_ID = "SELECT * FROM periodicals WHERE periodical_id=?";
    private static final String FIND_PERIODICALS_BY_NAME = "SELECT * FROM periodicals WHERE periodical_name=?";

    @Override
    public List<Periodical> findAllPeriodicals() {
        System.out.println("findAllPeriodicals...");
        List<Periodical> periodicals = new CopyOnWriteArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(FIND_ALL_PERIODICALS);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                periodicals.add(extractPeriodical(rs));
            }

            con.commit();
            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().close(con);
        }
        return periodicals;
    }

    @Override
    public Periodical findPeriodicalById(long id) {
        System.out.println("PeriodicalDao ищем по ID");
        Periodical periodical = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(FIND_PERIODICAL_BY_ID);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                periodical = extractPeriodical(rs);
            }

            con.commit();
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().close(con);
        }
        return periodical;
    }

    @Override
    public List<Periodical> findPeriodicalsByName(String name) {
        System.out.println("PeriodicalDao ищем по Name");
        List<Periodical> periodicals = new CopyOnWriteArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(FIND_PERIODICALS_BY_NAME);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                periodicals.add(extractPeriodical(rs));
            }

            con.commit();
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().close(con);
        }
        return periodicals;
    }

    @Override
    public boolean addPeriodical(Periodical periodical) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(INSERT_PERIODICAL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, periodical.getPublisher());
            pstmt.setString(2, periodical.getFrequency());
            pstmt.setString(3, periodical.getType());
            pstmt.setString(4, periodical.getName());
            pstmt.setBigDecimal(5, periodical.getPrice());
            pstmt.setString(6, periodical.getDescription());
            pstmt.executeUpdate();

            con.commit();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                periodical.setId(rs.getLong(1));
            }
            result = true;

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().close(con);
        }
        return result;
    }

    @Override
    public boolean updatePeriodical(Periodical periodical) {
        boolean result = false;
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(UPDATE_PERIODICAL);

            pstmt.setString(1, periodical.getPublisher());
            pstmt.setString(2, periodical.getFrequency());
            pstmt.setString(3, periodical.getType());
            pstmt.setString(4, periodical.getName());
            pstmt.setBigDecimal(5, periodical.getPrice());
            pstmt.setString(6, periodical.getDescription());
            pstmt.setLong(7, periodical.getId());

            System.out.println("обновляем издание");
            System.out.println(periodical);
            System.out.println(pstmt.executeUpdate());
            con.commit();

            result = true;

            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().close(con);
        }
        return result;
    }

    @Override
    public boolean deletePeriodicalById(long periodicalId) {
        boolean result = false;
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(DELETE_PERIODICAL_BY_ID);
            System.out.println("periodical id = " + periodicalId);
            pstmt.setLong(1, periodicalId);
            pstmt.executeUpdate();
            con.commit();

            result = true;
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().close(con);
        }
        return result;
    }

    private Periodical extractPeriodical(ResultSet rs) throws SQLException {
        Periodical periodical = new Periodical();
        periodical.setId(rs.getLong("periodical_id"));
        periodical.setPublisher(rs.getString("publisher"));
        periodical.setFrequency(rs.getString("frequency"));
        periodical.setType(rs.getString("periodical_type"));
        periodical.setName(rs.getString("periodical_name"));
        periodical.setPrice(rs.getBigDecimal("periodical_price"));
        periodical.setDescription(rs.getString("periodical_description"));
        return periodical;
    }

    private Connection getConnection() throws SQLException {
        return DBManager.getInstance().getConnection();
    }
}
