public class State
{
    String abbreviation;
    String full_name;
    Float unemployment;

    public State(String abbreviation, String full_name, Float unemployment)
    {
        this.abbreviation = abbreviation;
        this.full_name = full_name;
        this.unemployment = unemployment;
    }

//    @Override
//    public String toString() {
//        return "State{" +
//                "abbreviation='" + abbreviation + '\'' +
//                ", full_name='" + full_name + '\'' +
//                ", unemployment=" + unemployment +
//                '}';
//    }

    @Override
    public String toString() {
        return "The unemployment in " + full_name + " is " + unemployment + "%";
    }
}
