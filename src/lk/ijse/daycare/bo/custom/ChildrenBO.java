package lk.ijse.daycare.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.daycare.bo.SuperBO;
import lk.ijse.daycare.dto.ChildrenDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ChildrenBO extends SuperBO {
    ObservableList<ChildrenDTO> searchchildren(String text) throws SQLException, ClassNotFoundException;
    ResultSet getvalue(String valueOf) throws SQLException, ClassNotFoundException;
    ArrayList<ChildrenDTO> getAllChildrens() throws SQLException, ClassNotFoundException;
    boolean add(ChildrenDTO dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(ChildrenDTO dto) throws SQLException, ClassNotFoundException;

}
