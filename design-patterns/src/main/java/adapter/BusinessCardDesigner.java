package adapter;

public class BusinessCardDesigner
{
    public String designCard(Customer customer)
    {
        return String.format("Address : %s%n Designation : %s%n Name: %s%n", customer.getAddress(), customer.getDesignation(), customer.getName());
    }
}
