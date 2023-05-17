package lk.ijse.daycare.bo.custom.impl;

import lk.ijse.daycare.bo.custom.SalaryBO;
import lk.ijse.daycare.dao.DAOFactory;
import lk.ijse.daycare.dao.custom.SalaryDAO;
import lk.ijse.daycare.dto.SalaryDTO;
import lk.ijse.daycare.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {

    //SalaryDAO salaryDAO=new SalaryDAOImpl ();
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);
    @Override
    public boolean deleteSalarys(String eno) throws SQLException, ClassNotFoundException {
        return salaryDAO.deleteSalarys (eno);
    }

    @Override
    public boolean idIsExsist(String eno) throws SQLException, ClassNotFoundException {
        return salaryDAO.idIsExsist (eno);
    }

    @Override
    public ArrayList<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException {
        ArrayList<Salary> allSalary=salaryDAO.getAll ();
        ArrayList<SalaryDTO> all=new ArrayList<> ();
        for (Salary s : allSalary) {
            all.add (new SalaryDTO (s.getSalID (),s.getEmpID (),s.getName (),s.getAmount ()));
        }
        return all;
    }

    @Override
    public boolean addSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDAO.add (new Salary (dto.getSalID (),dto.getEmpID (),dto.getName (),dto.getAmount ()));
    }

    @Override
    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException {
        return salaryDAO.delete (id);
    }

    @Override
    public boolean updateSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDAO.update (new Salary (dto.getSalID (),dto.getEmpID (),dto.getName (),dto.getAmount ()));
    }
}
