package lk.ijse.daycare.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.daycare.dao.CrudUtil;
import lk.ijse.daycare.dao.custom.ChildrenDAO;
import lk.ijse.daycare.entity.Children;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class
ChildrenDAOImpl implements ChildrenDAO {
    public  ArrayList<Children> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Children> list = new ArrayList<>();
        ResultSet res = CrudUtil.execute("SELECT * FROM children");
        while (res.next()) {
            list.add(
                    new Children(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6)
                    )
            );

        }
        return list;
    }

    public  boolean add(Children children) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO children VALUES(?,?,?,?,?,?)",
                children.getCid(),
                children.getName(),
                children.getAddress(),
                children.getDob(),
                children.getAge(),
                children.getContact());
    }



    public  boolean update(Children children) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE  children SET cName=?,cAddress=?,dob=?,age=?,contact=? WHERE cID=?",
                children.getName(),
                children.getAddress(),
                children.getDob(),
                children.getAge(),
                children.getContact(),
                children.getCid()

        );
    }

    public  boolean delete(String cid) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM children WHERE cid = '"+cid+"'";
        return CrudUtil.execute(sql);
    }

    public ObservableList<Children> searchchildren(String text) throws SQLException, ClassNotFoundException {
        ObservableList<Children> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM children";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            Children children = new Children(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6));
            list.add(children);
        }
        return list;

    }

    public ResultSet getvalue(String valueOf) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT  c.cName,P.pID FROM parent P INNER JOIN  children c on P.cID = c.cID");
    }
}
