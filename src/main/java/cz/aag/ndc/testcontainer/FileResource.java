package cz.aag.ndc.testcontainer;

import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import io.quarkus.vertx.web.Route;

@ApplicationScoped
public class FileResource {

    private static final Logger LOGGER = Logger.getLogger(FileResource.class);

    @Inject
    Vertx vertx;

    @Route(path="/", methods = HttpMethod.GET)
    void hello(RoutingContext ctx) { 
        LOGGER.warn("GET");
        vertx.fileSystem().readFile("/data/ndc/lh/air-shopping.xml", res -> {
            if (res.succeeded()) {
                vertx.setTimer(3000, e -> { 
                    ctx.response().end(res.result());                        
                });                
            } else {
                LOGGER.warn("FAIL");
                ctx.fail(404);
            }
        });
    }
}
