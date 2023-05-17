package lk.ijse.daycare.dao.custom.impl;

import lk.ijse.daycare.dao.CrudUtil;
import lk.ijse.daycare.dao.custom.EmployeeDAO;
import lk.ijse.daycare.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    public  boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?)",
                employee.getEno(),
                employee.getName(),
                employee.getAddress(),
                employee.getContact(),
                employee.getPossition());
    }

    public  ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> list = new ArrayList<>();
        ResultSet res = CrudUtil.execute("SELECT * FROM employee");
        while (res.next()) {
            list.add(
                    new Employee(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5)

                    )
            );
        }
        return list;
    }


    public boolean delete(String eno) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM employee WHERE eno = ?", eno);
    }

    public Employee getByID(String id) throws SQLException, ClassNotFoundException {
        ResultSet res = CrudUtil.execute("SELECT * FROM employee WHERE eno = ?", id);
        if (res.next()) {
            return new Employee(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5)

            );
        }
        return null;
    }

    public  ResultSet getCount() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT COUNT(*) FROM employee");
    }

    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE employee SET eName=?, eAddress=?, ePhone=?, possition=? WHERE eNo=?",
                employee.getName(), employee.getAddress(), employee.getContact(), employee.getPossition(), employee.getEno());
    }
    /*public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET name = ? ,address  = ? , contact = ? , posstion = ? WHERE eno = ?";
        return CrudUtil.execute(sql,
                employee.getEno(),
                employee.getName(),
                employee.getAddress(),
                employee.getContact(),
                employee.getPossition());
    }
*/
}
