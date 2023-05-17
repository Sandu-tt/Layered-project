package lk.ijse.daycare.bo.custom;

import lk.ijse.daycare.bo.SuperBO;
import lk.ijse.daycare.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    public ArrayList<PaymentDTO> getAllPayment() throws SQLException, ClassNotFoundException;
    public boolean addPayment(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException;
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException;
    //public boolean update(Payment payment) throws SQLException, ClassNotFoundException;

}
