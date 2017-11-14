package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductTourGradeLanguageServicesDAO {

    public static boolean addproducttourgradelanguageservicesBean(ViatorProductTourGradeLanguageServicesBean viatorproducttourgradelanguageservicesBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorproducttourgradelanguageservicesBean);
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

    public static boolean deleteProductTourGradeLanguageServices(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductTourGradeLanguageServicesBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
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

    public static List<ViatorProductTourGradeLanguageServicesBean> getLanguageServicesByProductCodeAndTourGrade(String productCode,String tourGrade){

        Session session = HibernateUtil.getSession();
        List<ViatorProductTourGradeLanguageServicesBean> tourGradeLanguageServices=null;
        String hql ="Select tourGradeLanguageServices FROM ViatorProductTourGradeLanguageServicesBean tourGradeLanguageServices " +
                                                     "WHERE tourGradeLanguageServices.productCode like :productCode " +
                                                     "AND  tourGradeLanguageServices.gradeCode like :tourGrade";
        try{
            session.beginTransaction();
            tourGradeLanguageServices=session.createQuery(hql).setParameter("productCode", productCode )
                                                              .setParameter("tourGrade", tourGrade)
                                                              .getResultList();
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
        return tourGradeLanguageServices;
    }

    public static List<ViatorProductTourGradeLanguageServicesBean> getLanguageServicesByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductTourGradeLanguageServicesBean> tourGradeLanguageServices=null;
        String hql ="Select tourGradeLanguageServices FROM ViatorProductTourGradeLanguageServicesBean tourGradeLanguageServices " +
                "WHERE tourGradeLanguageServices.productCode like :productCode ";
        try{
            session.beginTransaction();
            tourGradeLanguageServices=session.createQuery(hql).setParameter("productCode", productCode )
                    .getResultList();
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
        return tourGradeLanguageServices;
    }
}
