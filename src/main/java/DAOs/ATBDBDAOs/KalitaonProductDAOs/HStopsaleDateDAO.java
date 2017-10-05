package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.HStopsaleDateBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 25/08/2017.
 */
public class HStopsaleDateDAO {

    public static boolean addStopsaleDate(HStopsaleDateBean stopsaleDateBean) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.insert(stopsaleDateBean);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            err = true;
            e.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            err = true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;

    }

    public static boolean deleteStopsaleDate(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM HStopsaleDateBean WHERE productId='"+code+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static List<HStopsaleDateBean> gethStopsaleDatesByProductId(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<HStopsaleDateBean> hStopsaleDates=null;
        String hql ="Select hStopsaleDates FROM HStopsaleDateBean hStopsaleDates " +
                "WHERE hStopsaleDates.productId like :productId ";
        try{
            session.beginTransaction();
            hStopsaleDates=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return hStopsaleDates;
    }
}
