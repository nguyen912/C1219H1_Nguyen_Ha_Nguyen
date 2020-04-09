import java.util.ArrayList;

public class CustomerController {
    Customer customer1 = new Customer("Nguyen Ha Nguyen", "09/12/1998", "123 TNV");
    Customer customer2 = new Customer("Nguyen Dieu Linh", "08/07/1996", "89 TDT");
    Customer customer3 = new Customer("Hoang Nhat Ha", "12/12/1992", "12 HD");
    Customer customer4 = new Customer("Tran Hoang Hao", "11/11/2011", "11 HH");
    Customer customer5 = new Customer("Ly Kieu Oanh", "03/09/2002", "77 NVL");

    public ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomerList() {
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
    }

    public void displayCustomer(ArrayList<Customer> customers) {
        addCustomerList();
        for (Customer customer : customerList) {
            System.out.printf(customer.toString());
        }
    }
}
