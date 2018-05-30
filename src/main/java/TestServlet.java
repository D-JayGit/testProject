import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by DhananJay on 30/5/18.
 */
@WebServlet(urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String body ="First 10 words remaining words";
            System.out.println("In the servlet");
            OutputStream o = resp.getOutputStream();
            ByteArrayInputStream bt = new ByteArrayInputStream(body.substring(0,20).getBytes());
            org.apache.commons.io.IOUtils.copy(bt,o);
            ByteArrayInputStream bt1 = new ByteArrayInputStream(body.substring(21,body.length()).getBytes());
            org.apache.commons.io.IOUtils.copy(bt1,o);
            Thread.sleep(3600000);




            OutputStreamWriter sw = new OutputStreamWriter(s.getOutputStream(),UTF_8);
            sw.write("POST /foo HTTP/1.0\r\n");
            sw.write("Content-Length: " + body.length() + "\r\n");
            sw.write("Content-Type: application/x-www-form-urlencoded\r\n");
            sw.write("\r\n");
            sw.flush();
            sw.write(body.substring(0,10));
            // Thread.sleep(15_000); // a little longer than the server timeout, which is 10 seconds
            // sw.write(body.substring(10));
            // sw.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
