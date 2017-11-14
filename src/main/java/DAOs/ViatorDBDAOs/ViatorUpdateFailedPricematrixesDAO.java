package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorUpdateFailedPricematrixesBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    public static List<String> getProductCodeByUpdateRid(int updateRid){

        Session session = HibernateUtil.getSession();
        List<String> failedProductCodes=null;
        String hql ="Select failedProducts.productWithFailedPricematrixes FROM ViatorUpdateFailedPricematrixesBean failedProducts " +
                "WHERE failedProducts.updateRid = :updateRid ";
        try{
            session.beginTransaction();
            failedProductCodes=session.createQuery(hql).setParameter("updateRid", updateRid).getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return failedProductCodes;
    }
}