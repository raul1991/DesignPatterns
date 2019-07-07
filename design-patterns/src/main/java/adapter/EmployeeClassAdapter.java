package adapter;

public class EmployeeClassAdapter extends Employee implements Customer
{
    @Override
    public String getName()
    {
        return getFullName();
    }

    @Override
    public String getAddress()
    {
        return getLocation();
    }

    @Override
    public String getDesignation()
    {
        return getJobName();
    }
}
