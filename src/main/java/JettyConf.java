import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import javax.servlet.http.HttpServlet;
import java.net.InetSocketAddress;

/**
 *
 * Created by DhananJay on 30/5/18.
 */
public class JettyConf {
    public static Server server;
    public static void main(String[] args) {
        try {
            server = new Server(new InetSocketAddress("127.0.0.1",8080));
            ServletContextHandler context = new ServletContextHandler(0);
            QueuedThreadPool queuedThreadPool = (QueuedThreadPool) server.getThreadPool();
            queuedThreadPool.setMaxThreads(7);
            context.addServlet(TestServlet.class,"/test");
            server.getBean(ServerConnector.class).setIdleTimeout(1);
            server.setHandler(context);
            server.start();
            System.out.println("TimeOut:"+server.getBean(ServerConnector.class).getIdleTimeout());
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    server.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
