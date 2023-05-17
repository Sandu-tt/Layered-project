package lk.ijse.daycare.bo.custom.impl;

import lk.ijse.daycare.bo.custom.EmployeeBO;
import lk.ijse.daycare.dao.DAOFactory;
import lk.ijse.daycare.dao.custom.EmployeeDAO;
import lk.ijse.daycare.dto.EmployeeDTO;
import lk.ijse.daycare.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allEmp=employeeDAO.getAll ();
        ArrayList<EmployeeDTO> all=new ArrayList<> ();
        for (Employee e : allEmp) {
            all.add (new EmployeeDTO (e.getEno (),e.getName (),e.getAddress (),e.getContact (),e.getPossition ()));
        }
        return all;
    }

    @Override
    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.add (new Employee (dto.getEno (),dto.getName (),dto.getAddress (),dto.getContact (),dto.getPossition ()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete (id);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update (new Employee (dto.getEno (),dto.getName (),dto.getAddress (),dto.getContact (),dto.getPossition ()));
    }

    @Override
    public ResultSet getCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getCount ();
    }

    @Override
    public Employee getByID(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.getByID (id);
    }
}
