package cz.aag.ndc.testcontainer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;

@ApplicationScoped
public class ApplicationLifeCycle {

    //http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
    // standart
    void onStart(@Observes StartupEvent ev) {
        
        System.out.println("  ____                 _     _                      ");
        System.out.println(" |  _ \\ _ __ _____   _(_) __| | ___ _ __           ");
        System.out.println(" | |_) | '__/ _ \\ \\ / / |/ _` |/ _ \\ '__|          ");
        System.out.println(" |  __/| | | (_) \\ V /| | (_| |  __/ |             ");
        System.out.println(" |_|   |_|  \\___/ \\_/ |_|\\__,_|\\___|_|             ");
        System.out.println("                                                   ");                                                
        System.out.println("Provider is starting with profile " + ProfileManager.getActiveProfile());   
        System.out.println("Provider is starting with profile " + ProfileManager.getActiveProfile());   
        System.out.println("Provider is starting with profile " + ProfileManager.getActiveProfile());   
        System.out.println("                                                   ");                
    }
    
    void onStop(@Observes ShutdownEvent ev) {
        System.out.println("Provider is stopping...");
    }
}
