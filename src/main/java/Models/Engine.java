package Models;

public class Engine
{
    private int modelId;
    private int engineId;
    private String engineType;
    private String extraSignature;
    private int engineCapacity;
    private int horsePower;

    public Engine(int modelId, int engineId, String engineType, String extraSignature, int engineCapacity, int horsePower)
    {
        this.modelId = modelId;
        this.engineId = engineId;
        this.engineType = engineType;
        this.extraSignature = extraSignature;
        this.engineCapacity = engineCapacity;
        this.horsePower = horsePower;
    }

    public int getModelId()
    {
        return modelId;
    }

    public int getEngineId()
    {
        return engineId;
    }

    public String getEngineType()
    {
        return engineType;
    }

    public String getExtraSignature()
    {
        return extraSignature;
    }

    public int getEngineCapacity()
    {
        return engineCapacity;
    }

    public int getHorsePower()
    {
        return horsePower;
    }
}
