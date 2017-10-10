package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author amitha.murali
 */
public class DB4OUtil {

    // path to the data store
    private static final String FILENAME = "C:\\Amitha Murali NEU\\AEDFinalProject_OnlineBanking (1)\\AEDFinalProject_OnlineBanking\\AEDFinalProject_OnlineBanking\\lib\\AEDOnlineBankData.db4o"; 
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer connection) {
        if (connection != null) {
            connection.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer dbObject = Db4oEmbedded.openFile(config, FILENAME);
            return dbObject;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer connection = createConnection();
        connection.store(system);
        connection.commit();
        connection.close();
    }
    
    public EcoSystem retrieveSystem(){
        ObjectContainer connection = createConnection();
        ObjectSet<EcoSystem> systems = connection.query(EcoSystem.class); // Change to the object you want to save
        EcoSystem system;
        if (systems.size() == 0){
            system = ConfigureASystem.configure();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        connection.close();
        return system;
    }
}
