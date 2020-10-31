package Models;

public class Series
{
    private int seriesId;
    private int producer_id;
    private String seriesName;
    private int productionStartYear;
    private int productionEndYear;

    public Series(int seriesId, int producer_id, String seriesName, int productionStartYear, int productionEndYear)
    {
        this.seriesId = seriesId;
        this.producer_id = producer_id;
        this.seriesName = seriesName;
        this.productionStartYear = productionStartYear;
        this.productionEndYear = productionEndYear;
    }

    public int getSeriesId()
    {
        return seriesId;
    }

    public int getProducer_id()
    {
        return producer_id;
    }

    public String getSeriesName()
    {
        return seriesName;
    }

    public int getProductionStartYear()
    {
        return productionStartYear;
    }

    public int getProductionEndYear()
    {
        return productionEndYear;
    }
}
