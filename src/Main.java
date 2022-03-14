import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    private static final String Database = "res/unemployment.csv";
    private static Scanner Reader = new Scanner (System.in);
    private static Map<String, State> MapState = new HashMap<>();

    public static void main (String[] args)
    {
        loadState();
    }

    private static void loadState()
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

                String abb = tokenizer.nextToken();
                String Full_name = tokenizer.nextToken();
                Float Unemployed = Float.valueOf(tokenizer.nextToken());

                State state = new State (abb);
                state.full_name = Full_name;
                state.unemployment = Unemployed;

                MapState.put(state.abbreviation, state);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error! Could not load state database!");
        }
        finally
        {
            reader.close();
        }
    }
}
