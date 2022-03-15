public class State
{
String abbreviation;
String full_name;
Float unemployment;

public State(String abb)
{
    abbreviation = abb;
    full_name = "none";
    unemployment = 0f;
}

public String toString()
{
    return "The unemployment in " + full_name + " is " + unemployment;
}
}
