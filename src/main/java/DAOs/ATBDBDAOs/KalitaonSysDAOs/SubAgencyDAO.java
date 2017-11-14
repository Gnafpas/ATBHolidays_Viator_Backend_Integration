package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;

/**
 * Created by George on 30/09/2017.
 */
public class SubAgencyDAO {

    public static SubAgencyBean getSubAgentByName(String agentName){

        Session session = ATBSysHibernateUtil.getSession();
        SubAgencyBean subAgency=null;
        String hql = "select subAgency from SubAgencyBean subAgency " +
                     "where subAgency.agentName like :agentName";
        try{
            session.beginTransaction();
            subAgency=(SubAgencyBean)session.createQuery(hql).setParameter("agentName",agentName ).getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return subAgency;
    }

    public static SubAgencyBean getSubAgentByStoreKey(String stroreKey){

        Session session = ATBSysHibernateUtil.getSession();
        SubAgencyBean subAgency=null;
        String hql = "select subAgency from SubAgencyBean subAgency " +
                "where subAgency.xmlStorekey like :stroreKey";
        try{
            session.beginTransaction();
            subAgency=(SubAgencyBean)session.createQuery(hql).setParameter("stroreKey",stroreKey ).getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return subAgency;
    }

    public static int storeAgentAPIKey(String agentName,String xmlStorekey){


        SubAgencyBean  subAgencyBean=null;
        subAgencyBean=getSubAgentByName(agentName);
        if(subAgencyBean==null){
            subAgencyBean=new SubAgencyBean();
            subAgencyBean.setAgentName(agentName);
            subAgencyBean.setXmlStorekey(xmlStorekey);
            subAgencyBean.setLastName("");
            subAgencyBean.setFirstName("");
            subAgencyBean.setTypeOfAgency("");
            subAgencyBean.setActivation("");
            subAgencyBean.setAccountNumber("");
            subAgencyBean.setAccountName("");
            subAgencyBean.setAsta("");
            subAgencyBean.setBankAddress("");
            subAgencyBean.setBankCity("");
            subAgencyBean.setBankCountry("");
            subAgencyBean.setBankName("");
            subAgencyBean.setBankState("");
            subAgencyBean.setBillingAddress("");
            subAgencyBean.setBillingEmail("");
            subAgencyBean.setCityCode("");
            subAgencyBean.setCityName("");
            subAgencyBean.setClia("");
            subAgencyBean.setCommission("");
            subAgencyBean.setCountryCode("");
            subAgencyBean.setCountryName("");
            subAgencyBean.setCreatedDate("");
            subAgencyBean.setCurrency("");
            subAgencyBean.setDeposit("");
            subAgencyBean.setGsaId("");
            subAgencyBean.setEmail("");
            subAgencyBean.setIata("");
            subAgencyBean.setIban("");
            subAgencyBean.setJobTitle("");
            subAgencyBean.setLogo("");
            subAgencyBean.setMarkup("");
            subAgencyBean.setMobile("");
            subAgencyBean.setNotes("");
            subAgencyBean.setSwift("");
            subAgencyBean.setOther("");
            subAgencyBean.setTaxNo("");
            subAgencyBean.setTaxOffice("");
            subAgencyBean.setTelephone("");
            subAgencyBean.setTursab("");
            subAgencyBean.setXmlStatus("");
            subAgencyBean.setWeb("");



        }
        else
            subAgencyBean.setXmlStorekey(xmlStorekey);

        int subAgency=0;

        Session session = ATBSysHibernateUtil.getSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(subAgencyBean);
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
        return subAgency;
    }

}
