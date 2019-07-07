package creational.builder;

public class User
{
    private String name;
    private String address;
    private int age;
    // optional fields
    private String aadharId;
    private String panCardNumber;
    private String githubHandle;

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", aadharId='" + aadharId + '\'' +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", githubHandle='" + githubHandle + '\'' +
                '}';
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getAadharId()
    {
        return aadharId;
    }

    public String getPanCardNumber()
    {
        return panCardNumber;
    }

    public String getGithubHandle()
    {
        return githubHandle;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    private void setAddress(String address)
    {
        this.address = address;
    }

    private void setAge(int age)
    {
        this.age = age;
    }

    private void setAadharId(String aadharId)
    {
        this.aadharId = aadharId;
    }

    private void setPanCardNumber(String panCardNumber)
    {
        this.panCardNumber = panCardNumber;
    }

    private void setGithubHandle(String githubHandle)
    {
        this.githubHandle = githubHandle;
    }

    public static UserDTOBuilder getBuilder()
    {
        return new UserBuilder();
    }
    private static class UserBuilder implements UserDTOBuilder
    {
        private String fname;
        private String userAddress;
        private int userAge;
        // optional fields
        private String aid;
        private String pan;
        private String github;

        public UserDTOBuilder name(String name)
        {
            fname = name;
            return this;
        }

        public UserDTOBuilder address(String address)
        {
            userAddress = address;
            return this;
        }

        public UserDTOBuilder age(int age)
        {
            userAge = age;
            return this;
        }

        public UserDTOBuilder aadharId(String aadharId)
        {
            aid = aadharId;
            return this;
        }

        public UserDTOBuilder panCardNumber(String panId)
        {
            pan = panId;
            return this;
        }

        public UserDTOBuilder githubHandle(String githubHandle)
        {
            github = githubHandle;
            return this;
        }

        public User build()
        {
            User user = new User();
            user.setName(fname);
            user.setAddress(userAddress);
            user.setAge(userAge);
            user.setAadharId(aid);
            user.setPanCardNumber(pan);
            user.setGithubHandle(github);
            return user;
        }
    }
}
