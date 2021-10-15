/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import helper.PersistenceHelper;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.TbMahasiswa;
import viewer.EntryData;

/**
 *
 * @author Ilham Sihabudin
 */
public class TbMahasiswaJpaController implements Serializable {
    private EntryData view;
    
    public TbMahasiswaJpaController(EntryData view) {
        this.view = view;
    }

    public void create()  {
        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
        manager.getTransaction().begin();
        try {
            TbMahasiswa tbMahasiswa = new TbMahasiswa();
            tbMahasiswa.setNrp(view.getTextNrp().getText());
            tbMahasiswa.setNama(view.getTextNama().getText());
            tbMahasiswa.setAngkatan(view.getTextAngkatan().getText());
            tbMahasiswa.setSekolahAsal(view.getTextAsalSekolah().getText());
            
            view.getTextNrp().setText("");
            view.getTextNama().setText("");
            view.getTextAngkatan().setText("");
            view.getTextAsalSekolah().setText("");
            
            manager.persist(tbMahasiswa);
            view.getTableModelMahasiswa().insert(tbMahasiswa);
            
            manager.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
	    manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    public void update() {
        int index = view.getTableMahasiswa().getSelectedRow();
        if (index == -1) {
            return;
        }
        
        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
	manager.getTransaction().begin();
        try {
            TbMahasiswa tbMahasiswa = view.getTableModelMahasiswa().select(index);
            tbMahasiswa.setNrp(view.getTextNrp().getText());
            tbMahasiswa.setNama(view.getTextNama().getText());
            tbMahasiswa.setAngkatan(view.getTextAngkatan().getText());
            tbMahasiswa.setSekolahAsal(view.getTextAsalSekolah().getText());
            
            view.getTextNrp().setText("");
            view.getTextNama().setText("");
            view.getTextAngkatan().setText("");
            view.getTextAsalSekolah().setText("");
            
            manager.merge(tbMahasiswa);
            view.getTableModelMahasiswa().update(index, tbMahasiswa);
            
            manager.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
	    manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    public void delete() {
        int index = view.getTableMahasiswa().getSelectedRow();
        if (index == -1){
            return;
        }
        
        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
	manager.getTransaction().begin();
        try {
            TbMahasiswa tbMahasiswa = view.getTableModelMahasiswa().select(index);
            
            manager.remove(manager.merge(tbMahasiswa));
            view.getTableModelMahasiswa().delete(index);
            
            manager.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
	    manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    public void select() {
	EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
	try {
	    @SuppressWarnings("unchecked")
	    List list = manager.createQuery("select a from TbMahasiswa a").getResultList();
	    view.getTableModelMahasiswa().updateAll(list);
	} finally {
	    manager.close();
	}
    }
}
