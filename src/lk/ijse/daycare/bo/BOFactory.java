package lk.ijse.daycare.bo;

import lk.ijse.daycare.bo.custom.impl.ChildrenBOImpl;
import lk.ijse.daycare.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.daycare.bo.custom.impl.PaymentBOImpl;
import lk.ijse.daycare.bo.custom.impl.SalaryBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CHILDREN,EMPLOYEE,PAYMENT,SALARY
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CHILDREN:
                return new ChildrenBOImpl ();
            case EMPLOYEE:
                return new EmployeeBOImpl ();
            case PAYMENT:
                return new PaymentBOImpl ();
            case SALARY:
                return new SalaryBOImpl ();
            default:
                return null;
        }
    }
}
