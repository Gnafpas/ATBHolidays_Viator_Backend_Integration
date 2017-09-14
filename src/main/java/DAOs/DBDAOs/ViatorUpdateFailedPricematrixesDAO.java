package DAOs.DBDAOs;

import DBBeans.ViatorUpdateFailedPricematrixesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 20/08/2017.
 */
public class ViatorUpdateFailedPricematrixesDAO {

    public static boolean addViatorUpdateFailedPricematrixes(ViatorUpdateFailedPricematrixesBean viatorUpdateFailedPricematrixesBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorUpdateFailedPricematrixesBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }
        return err;
    }
}
