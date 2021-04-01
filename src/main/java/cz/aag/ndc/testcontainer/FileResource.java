package cz.aag.ndc.testcontainer;

import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import io.quarkus.vertx.web.Route;

@ApplicationScoped
public class FileResource {

    private static final Logger LOGGER = Logger.getLogger(FileResource.class);

    @Inject
    Vertx vertx;

    WebClient webClient;

    @PostConstruct
    void initialize() {
        LOGGER.warn("intializing FileResource");
        webClient = WebClient.create(vertx);
    } 

    @Route(path="/", methods = HttpMethod.GET)
    void read(RoutingContext ctx) { 
        LOGGER.warn("read");
        // vertx.fileSystem().readFile("/data/ndc/lh/air-shopping.xml", res -> {
        //     if (res.succeeded()) {
                               
        //     } else {
        //         LOGGER.warn("FAIL");
        //         ctx.fail(404);
        //     }
        // });

        vertx.setTimer(3000, e -> { 
            ctx.response().end("{}");                        
        });
    }


    @Route(path="/test", methods = HttpMethod.GET)
    void test(RoutingContext ctx) { 
        
    }
    
    Future<String> fetch() {
        Promise<String> promise = Promise.promise();
        webClient
            .get(8080, "localhost", "/")
            .send(res -> {

            });        
        return promise.future();
    }   
}
