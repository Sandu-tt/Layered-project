package lk.ijse.daycare.bo.custom;

import lk.ijse.daycare.bo.SuperBO;
import lk.ijse.daycare.dto.EmployeeDTO;
import lk.ijse.daycare.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;
    public boolean addEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    ResultSet getCount() throws SQLException, ClassNotFoundException ;
    Employee getByID(String id) throws SQLException, ClassNotFoundException;

}
