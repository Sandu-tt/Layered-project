package lk.ijse.daycare.dao.custom.impl;

import lk.ijse.daycare.dao.CrudUtil;
import lk.ijse.daycare.dao.custom.PaymentDAO;
import lk.ijse.daycare.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    public  boolean add(Payment p) throws SQLException, ClassNotFoundException {
//        System.out.println( p.getPmID()+ p.getcID()+ p.getName() + p.getAmount());
        boolean a = CrudUtil.execute("INSERT  INTO payment VALUES(?,?,?,?)",
                p.getPmID(), p.getcID(), p.getName(), p.getAmount());

        return a;
    }

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM payment WHERE pmID=?", id);
    }

    @Override
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> list = new ArrayList<>();
        ResultSet res = CrudUtil.execute("SELECT * FROM payment");
        while (res.next()) {
//            System.out.println(res.getString(2));
            list.add(
                    new Payment(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getDouble(4)
                    )
            );
        }

        return list;
    }
}
