import java.io.File;
import java.util.*;

public class Load
{
    private static final String Database = "res/unemployment.csv";
    private static Scanner reader = new Scanner (System.in);
    private static Map<String, State> MapState = new HashMap<>();

    public static Map<String, State> getMapState() {
        return MapState;
    }

    public Load()
    {
    }

    public void loadState()
    {
        File file = new File(Database);
        Scanner reader = null;

        if(!file.exists())
        {
            System.out.println("Error! Could not find state database.");
            return;
        }

        try
        {
            reader = new Scanner(file);
            reader.nextLine();

            while (reader.hasNext())
            {
                String info = reader.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(info, ",");

                String ab = tokenizer.nextToken();
                String Full_name = tokenizer.nextToken();
                Float Unemployed = Float.valueOf(tokenizer.nextToken());

                State state = new State (ab, Full_name, Unemployed);
                MapState.put(state.abbreviation, state);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error! Could not load state database!");
        }
        finally
        {
            if (reader != null)
            reader.close();
        }
    }
}
