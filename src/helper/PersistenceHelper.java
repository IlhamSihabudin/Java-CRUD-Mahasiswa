/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ilham Sihabudin
 */
public class PersistenceHelper {
    private static final EntityManagerFactory factory;

    static {
	factory = Persistence.createEntityManagerFactory("tugasBesar1PU");
    }

    public static EntityManagerFactory getFactory() {
	return factory;
    }
}
