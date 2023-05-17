package lk.ijse.daycare.dao.custom.impl;

import lk.ijse.daycare.dao.CrudUtil;
import lk.ijse.daycare.dao.custom.EmployeeDAO;
import lk.ijse.daycare.dao.custom.SalaryDAO;
import lk.ijse.daycare.db.DBConnection;
import lk.ijse.daycare.entity.Salary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {
    public  boolean add(Salary s) throws SQLException, ClassNotFoundException {
        boolean b = CrudUtil.execute("INSERT INTO salary VALUES(?,?,?,?)",
                s.getSalID(), s.getEmpID(), s.getName(), s.getAmount());

        return b;
    }

    public  ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Salary> list = new ArrayList<>();
        ResultSet res = CrudUtil.execute("SELECT * FROM salary");
        while (res.next()) {
            list.add(
                    new Salary(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getDouble(4)
                    )
            );
        }

        return list;
    }

    public boolean idIsExsist(String eno) throws SQLException, ClassNotFoundException {
        ResultSet execute = CrudUtil.execute("SELECT * FROM salary WHERE eNo=?", eno);
        return execute.next();
    }

    public  boolean delete(String eno) throws SQLException {
        EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (deleteSalarys(eno)) {
                if (employeeDAO.delete(eno)) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }

        return false;
    }

    @Override
    public boolean update(Salary entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean deleteSalarys(String eno) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM salary WHERE eNo=?",eno);
    }
}
