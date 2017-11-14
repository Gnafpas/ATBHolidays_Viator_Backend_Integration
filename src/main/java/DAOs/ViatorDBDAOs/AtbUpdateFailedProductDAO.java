package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.AtbUpdateFailedProductBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 03/10/2017.
 */
public class AtbUpdateFailedProductDAO {

    public static boolean addATBUpdateFailedProduct(AtbUpdateFailedProductBean atbUpdateFailedProductBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(atbUpdateFailedProductBean);
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }
}