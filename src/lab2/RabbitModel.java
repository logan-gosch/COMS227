package lab2;
//
//public class RabbitModel
//{
//    private int population;
//    /**
//     * Constructs a new lab2.RabbitModel.
//     */
//    public RabbitModel()
//    {
//        population = 0;
//    }
//
//    /**
//     * Returns the current number of rabbits.
//     * @return
//     *   current rabbit population
//     */
//    public int getPopulation()
//    {
//        return population;
//    }
//
//    /**
//     * Updates the population to simulate the
//     * passing of one year.
//     */
//    public void simulateYear()
//    {
//        population += 1;
//        if (population % 5 == 0) {
//            reset();
//        }
//    }
//
//    /**
//     * Sets or resets the state of the model to the
//     * initial conditions.
//     */
//    public void reset()
//    {
//        population = 0  ;
//    }
//}

//public class RabbitModel
//{
//    // TODO - add instance variables as needed
//    private int population;
//    /**
//     * Constructs a new lab2.RabbitModel.
//     */
//    public RabbitModel()
//    {
//        // TODO
//        population = 500;
//    }
//
//    /**
//     * Returns the current number of rabbits.
//     * @return
//     *   current rabbit population
//     */
//    public int getPopulation()
//    {
//        // TODO - returns a dummy value so code will compile
//        return population;
//    }
//
//    /**
//     * Updates the population to simulate the
//     * passing of one year.
//     */
//    public void simulateYear()
//    {
//        // TODO
//        population /= 2;
//    }
//
//    /**
//     * Sets or resets the state of the model to the
//     * initial conditions.
//     */
//    public void reset()
//    {
//        // TODO
//        population = 500;
//    }
//}

//import java.util.Random;
//
//public class RabbitModel
//{
//    private int population;
//    /**
//     * Constructs a new lab2.RabbitModel.
//     */
//    public RabbitModel()
//    {
//        // TODO
//        population = 1;
//    }
//
//    /**
//     * Returns the current number of rabbits.
//     * @return
//     *   current rabbit population
//     */
//    public int getPopulation()
//    {
//        return population;
//    }
//
//    /**
//     * Updates the population to simulate the
//     * passing of one year.
//     */
//    public void simulateYear()
//    {
//        Random rand = new Random();
//        int populationIncrease = rand.nextInt(10);
//        population += populationIncrease;
//    }
//
//    /**
//     * Sets or resets the state of the model to the
//     * initial conditions.
//     */
//    public void reset()
//    {
//        population = 1;
//    }
//}

public class RabbitModel
{
    private int population;
    private int lastYear;
    private int yearBefore;

    /**
     * Constructs a new lab2.RabbitModel.
     */
    public RabbitModel()
    {
        lastYear = 1;
        yearBefore = 0;
        population = 0;
    }

    /**
     * Returns the current number of rabbits.
     * @return
     *   current rabbit population
     */
    public int getPopulation()
    {
        // TODO - returns a dummy value so code will compile
        return population;
    }

    /**
     * Updates the population to simulate the
     * passing of one year.
     */
    public void simulateYear()
    {
        population = lastYear + yearBefore;
        yearBefore = lastYear;
        lastYear = population;
    }

    /**
     * Sets or resets the state of the model to the
     * initial conditions.
     */
    public void reset()
    {
        lastYear = 1;
        yearBefore = 0;
        population = 0;
    }
}