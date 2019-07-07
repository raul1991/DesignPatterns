package adapter;

public class Client
{
    public static void main(String[] args)
    {
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        adapter.setFullName("Rahul Bawa");
        adapter.setJobName("Engineer");
        adapter.setLocation("Boston");
        BusinessCardDesigner designer = new BusinessCardDesigner();
        System.out.println(designer.designCard(adapter));
    }
}
