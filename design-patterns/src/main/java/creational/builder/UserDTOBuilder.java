package creational.builder;

public interface UserDTOBuilder
{
    UserDTOBuilder name(String name);
    UserDTOBuilder address(String address);
    UserDTOBuilder age(int age);
    UserDTOBuilder aadharId(String aadharId);
    UserDTOBuilder panCardNumber(String pan);
    UserDTOBuilder githubHandle(String github);
    User build();
}
