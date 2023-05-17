package lk.ijse.daycare.bo.custom.impl;

import lk.ijse.daycare.bo.custom.PaymentBO;
import lk.ijse.daycare.dao.DAOFactory;
import lk.ijse.daycare.dao.custom.PaymentDAO;
import lk.ijse.daycare.dto.PaymentDTO;
import lk.ijse.daycare.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    //PaymentDAO paymentDAO=new PaymentDAOImpl ();
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public ArrayList<PaymentDTO> getAllPayment() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> all=paymentDAO.getAll ();
        ArrayList<PaymentDTO>allPay=new ArrayList<> ();

        for (Payment p : all) {
            allPay.add (new PaymentDTO (p.getPmID (),p.getcID (),p.getName (),p.getAmount ()));
        }

        return allPay;
    }

    @Override
    public boolean addPayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.add (new Payment (dto.getPmID (),dto.getcID (),dto.getName (),dto.getAmount ()));
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete (id);
    }
}
