package lk.ijse.daycare.dao.custom;

import lk.ijse.daycare.dao.CrudDAO;
import lk.ijse.daycare.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee> {
    ResultSet getCount() throws SQLException, ClassNotFoundException ;
    Employee getByID(String id) throws SQLException, ClassNotFoundException;
}
