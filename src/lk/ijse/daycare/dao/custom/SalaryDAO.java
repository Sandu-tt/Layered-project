package lk.ijse.daycare.dao.custom;

import lk.ijse.daycare.dao.CrudDAO;
import lk.ijse.daycare.entity.Salary;

import java.sql.SQLException;

public interface SalaryDAO extends CrudDAO<Salary> {
    boolean deleteSalarys(String eno) throws SQLException, ClassNotFoundException;
    boolean idIsExsist(String eno) throws SQLException, ClassNotFoundException;
}
