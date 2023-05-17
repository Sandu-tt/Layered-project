package lk.ijse.daycare.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.daycare.dao.CrudDAO;
import lk.ijse.daycare.entity.Children;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ChildrenDAO extends CrudDAO<Children> {
    ObservableList<Children> searchchildren(String text) throws SQLException, ClassNotFoundException;
    ResultSet getvalue(String valueOf) throws SQLException, ClassNotFoundException;
}
