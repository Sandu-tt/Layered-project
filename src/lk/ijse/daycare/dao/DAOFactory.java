package lk.ijse.daycare.dao;

import lk.ijse.daycare.dao.custom.impl.ChildrenDAOImpl;
import lk.ijse.daycare.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.daycare.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.daycare.dao.custom.impl.SalaryDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CHILDREN,EMPLOYEE,PAYMENT,SALARY
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CHILDREN:
                return new ChildrenDAOImpl ();
            case EMPLOYEE:
                return new EmployeeDAOImpl ();
            case PAYMENT:
                return new PaymentDAOImpl ();
            case SALARY:
                return new SalaryDAOImpl ();
            default:
                return null;
        }
    }

}
