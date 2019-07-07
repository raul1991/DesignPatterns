package creational.builder;

public class Main
{
    public static void main(String[] args)
    {
        final User user =
                User.getBuilder().name("Rahul Bawa").address("4/69 Subhash Nagar").age(27).aadharId("uaidai123")
                    .panCardNumber("boy").githubHandle("raul1991").build();
        System.out.println(user);

    }
}
