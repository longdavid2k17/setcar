package Models;

public class Producer
{
    private int id;
    private String name;
    private int yearOfCompanyCreation;
    private String headquarters;

    public Producer(int id, String name, int yearOfCompanyCreation, String headquarters)
    {
        this.id = id;
        this.name = name;
        this.yearOfCompanyCreation = yearOfCompanyCreation;
        this.headquarters = headquarters;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getYearOfCompanyCreation()
    {
        return yearOfCompanyCreation;
    }

    public String getHeadquarters()
    {
        return headquarters;
    }
}
