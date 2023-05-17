package lk.ijse.daycare.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.daycare.bo.custom.ChildrenBO;
import lk.ijse.daycare.dao.DAOFactory;
import lk.ijse.daycare.dao.custom.ChildrenDAO;
import lk.ijse.daycare.dto.ChildrenDTO;
import lk.ijse.daycare.entity.Children;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChildrenBOImpl implements ChildrenBO {

    //ChildrenDAO childrenDAO=new ChildrenDAOImpl ();
    ChildrenDAO childrenDAO = (ChildrenDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CHILDREN);
    @Override
    public ObservableList<ChildrenDTO> searchchildren(String text) throws SQLException, ClassNotFoundException {
        ObservableList<Children>  searchchildren=childrenDAO.searchchildren (text);
        ObservableList<ChildrenDTO> searchAll= FXCollections.observableArrayList ();
        for (Children s : searchchildren) {
            searchAll.add (new ChildrenDTO (s.getCid (),s.getName (),s.getAddress (),s.getDob (),s.getAge (),s.getContact ()));
        }

        return searchAll;
    }

    @Override
    public ResultSet getvalue(String valueOf) throws SQLException, ClassNotFoundException {
        return childrenDAO.getvalue (valueOf);
    }

    @Override
    public ArrayList<ChildrenDTO> getAllChildrens() throws SQLException, ClassNotFoundException {
        ArrayList<Children> alldetail=childrenDAO.getAll ();
        ArrayList<ChildrenDTO>allChild=new ArrayList<> ();
        for (Children c : alldetail) {
            allChild.add (new ChildrenDTO (c.getCid (),c.getName (),c.getAddress (),c.getDob (),c.getAge (),c.getContact ()));
        }
        return allChild;
    }

    @Override
    public boolean add(ChildrenDTO dto) throws SQLException, ClassNotFoundException {
        return childrenDAO.add (new Children (dto.getCid (),dto.getName (),dto.getAddress (),dto.getDob (),dto.getAge (),dto.getContact ()));

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return childrenDAO.delete (id);
    }

    @Override
    public boolean update(ChildrenDTO dto) throws SQLException, ClassNotFoundException {
        return childrenDAO.update (new Children (dto.getCid (),dto.getName (),dto.getAddress (),dto.getDob (),dto.getAge (),dto.getContact ()));
    }
}
