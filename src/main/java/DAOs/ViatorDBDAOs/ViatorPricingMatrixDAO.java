package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorPricingMatrixBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 19/08/2017.
 */
public class ViatorPricingMatrixDAO {

    public static  boolean addPricingMatrix(ViatorPricingMatrixBean viatorPricingMatrixBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorPricingMatrixBean);
            tx.commit();
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

    public static List<ViatorPricingMatrixBean> getPricingMatrixByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorPricingMatrixBean> pricingMatrixBean=null;
        String hql ="Select pricingMatrix FROM ViatorPricingMatrixBean pricingMatrix " +
                "WHERE pricingMatrix.productCode like :productCode " +
                "order by pricingMatrix.sortOrderOfDate," +
                         "pricingMatrix.sortOrderOfTourGrade," +
                         "pricingMatrix.sortOrderOfPricing," +
                         "pricingMatrix.sortOrderOfAgeBand," +
                         "pricingMatrix.sortOrderOfPrice " ;
        try{
            session.beginTransaction();
            pricingMatrixBean=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return pricingMatrixBean;
    }
}
