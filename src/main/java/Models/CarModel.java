package Models;

public class CarModel
{
    static int counter = 0;

    private int carId;
    private Producer producer;
    private Series series;
    private Engine engine;
    private Exploitation exploitation;
    private String carSignature;
    private String carType;
    private double height;
    private double length;
    private double weight;
    private double averagePrice;

    public CarModel(int carId, Producer producer, Series series, Engine engine, Exploitation exploitation, String carSignature, String carType, double height, double length, double weight, double averagePrice) {
        this.carId = carId;
        this.producer = producer;
        this.series = series;
        this.engine = engine;
        this.exploitation = exploitation;
        this.carSignature = carSignature;
        this.carType = carType;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.averagePrice = averagePrice;
    }

    public int getCarId()
    {
        return carId;
    }

    public void setCarId(int carId)
    {
        this.carId = carId;
    }

    public Producer getProducer()
    {
        return producer;
    }

    public void setProducer(Producer producer)
    {
        this.producer = producer;
    }

    public Series getSeries()
    {
        return series;
    }

    public void setSeries(Series series)
    {
        this.series = series;
    }

    public Engine getEngine()
    {
        return engine;
    }

    public void setEngine(Engine engine)
    {
        this.engine = engine;
    }

    public Exploitation getExploatation()
    {
        return exploitation;
    }

    public void setExploatation(Exploitation exploitation)
    {
        this.exploitation = exploitation;
    }

    public String getCarSignature()
    {
        return carSignature;
    }

    public void setCarSignature(String carSignature)
    {
        this.carSignature = carSignature;
    }

    public String getCarType()
    {
        return carType;
    }

    public void setCarType(String carType)
    {
        this.carType = carType;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getAveragePrice()
    {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice)
    {
        this.averagePrice = averagePrice;
    }
}
