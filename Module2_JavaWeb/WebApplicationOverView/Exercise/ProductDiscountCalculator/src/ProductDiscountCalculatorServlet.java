import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Product Discount CalculatorServlet", urlPatterns = "/display_discount")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount_percent"));
        int discount_amount = price * discount_percent / 100;
        int discount_price = price - discount_amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>\n" +
                "    <title>Product Discount Calculator</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "  </head>");
        writer.println("<div id=\"content\">\n" +
                "      <h1>Product Discount Calculator</h1>\n" +
                "      <form method=\"post\" action=\"display_discount\">\n" +
                "        <div id=\"data\">");
        writer.println("<label>Product Description:</label>" + description + "<br>");
        writer.println("<label>List Price:</label>" + price + " dong" + "<br>");
        writer.println("<label>Discount Percent:</label>" + discount_percent + "%" + "<br>");
        writer.println("<label>Discount Amount:</label>" + discount_amount + " dong" + "<br>");
        writer.println("<label>Discount Price:</label>" + discount_price + " dong");
        writer.println("</div>");
        writer.println("</form>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
