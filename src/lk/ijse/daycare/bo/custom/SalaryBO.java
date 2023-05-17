package lk.ijse.daycare.bo.custom;

import lk.ijse.daycare.bo.SuperBO;
import lk.ijse.daycare.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryBO extends SuperBO {
    boolean deleteSalarys(String eno) throws SQLException, ClassNotFoundException;
    boolean idIsExsist(String eno) throws SQLException, ClassNotFoundException;
    public ArrayList<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException;
    public boolean addSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException;
    public boolean updateSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

}
