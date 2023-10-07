package lab3;

public class Basketball {
    double diameter;
    boolean dribbleable;
    public Basketball (double givenDiameter) {
        diameter = givenDiameter;
        dribbleable = false;
    }

    public boolean isDribbleable () {
        return dribbleable;
    }

    public double getDiameter () {
        return diameter;
    }

    public double getCircumference () {
        return 0;
    }

    public void inflate () {
        dribbleable = true;
    }

}
