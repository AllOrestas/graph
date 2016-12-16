package lt.kvk.i9.pavarde_vardas.data;

/**
 * Created by Pikis on 12/1/2016.
 */
public class Data
{
    String name;
    String value;
    String date;

    public Data(String name, String value, String date)
    {
        this.name = name;
        this.value = value;
        this.date = date;
    }

    @Override
    public String toString() {
        return "lt.kvk.i9.pavarde_vardas.data.Data{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", date='" + date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }
}
