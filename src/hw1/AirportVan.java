package hw1;

/**
 * @author Logan Gosch
 */
public class AirportVan {

    /** Maximum number of riders for the van. */
    private final int MAX_RIDERS;
    /** Given time bonus multiplier for the van. */
    private final int TIME_BONUS;
    /** Given mileage bonus multiplier for the van. */
    private final int MILEAGE_BONUS;
    /** Given hourly for the van driver's wage. */
    private final double HOURLY_RATE;
    /** Current time bonus points. */
    private int timeBonus = 0;
    /** Current mileage bonus points. */
    private int milesBonus = 0;
    /** Total time passed since van's creation. */
    private int minutesPassed = 0;
    /** Total miles driven since van's creation. */
    private int milesDriven = 0;
    /** Current number of passengers in the van. */
    private int numRiders = 0;
    /** Total tips accumulated. */
    private double tipsTotal = 0;



    /**
     * Creates an airport van object
     * @param givenHourlyRate
     *  The provided hourly rate for the driver
     * @param givenMileageBonus
     *  The provided mileage bonus for the driver
     * @param givenTimeBonus
     *  The provided time bonus for the driver
     * @param givenMaxRiders
     *  The maximum capacity for any given van
     */
    public AirportVan(double givenHourlyRate, int givenMileageBonus,
                      int givenTimeBonus, int givenMaxRiders) {
        MAX_RIDERS = givenMaxRiders;
        MILEAGE_BONUS = givenMileageBonus;
        TIME_BONUS = givenTimeBonus;
        HOURLY_RATE = givenHourlyRate;
    }

    /**
     * Have the van drive for a certain distance and time.
     * @param miles
     *  miles driven
     * @param minutes
     *  minutes drove
     */
    public void drive(int miles, int minutes) {
        milesDriven += miles;
        minutesPassed += minutes;
        timeBonus += minutes * Math.min(numRiders, 1) * TIME_BONUS;
        milesBonus += Math.max(1, numRiders) * miles * MILEAGE_BONUS;
    }

    /**
     * Pickup a passenger, will not add a passenger if maximum
     *  riders are present.
     */
    public void pickUp() {
        numRiders = Math.min(numRiders + 1, MAX_RIDERS);
    }

    /**
     * Drops off a passenger and adds a tip to the total tips received.
     * @param tip
     *  The amount of money passenger leave for the driver as a tip.
     */
    public void dropOff(double tip) {
        tipsTotal += tip * Math.min(numRiders, 1);
        numRiders = Math.max(numRiders - 1, 0);
    }

    /**
     * Passes time without driving or adding miles.
     * @param minutes
     *  The amount of minutes to wait around.
     */
    public void waitAround(int minutes) {
        minutesPassed += minutes;
        timeBonus += minutes * Math.min(numRiders, 1) * TIME_BONUS;
    }

    /**
     * Calculates the average pay from totals added so far.
     * @param dollarsPerPoint
     *  Given conversion factor from points into money.
     * @return
     *  Returns the average pay from the total money received and time elapsed so far.
     */
    public double getAverageHourlyPay(double dollarsPerPoint) {
        return getTotalPay(dollarsPerPoint) / ((double) minutesPassed / 60.0);
    }

    /**
     * Calculates the total from all money sources: wage, tips, and bonus points.
     * @param dollarsPerPoint
     *  Given conversion factor from points into money.
     * @return
     *  Returns total pay from revenue sources so far.
     */
    public double getTotalPay(double dollarsPerPoint) {
        return (HOURLY_RATE * ((double) minutesPassed / 60.0) + ((double) getTotalPoints() * dollarsPerPoint) + getTotalTips());
    }

    /**
     * Returns total tips received thus far.
     * @return
     */
    public double getTotalTips() {
        return tipsTotal;
    }

    /**
     * Return current rider count.
     * @return
     */
    public int getRiderCount() {
        return numRiders;
    }

    /**
     * Return total miles driven thus far.
     * @return
     */
    public int getTotalMiles() {
        return milesDriven;
    }

    /**
     * Returns total points accumulated thus far.
     * @return
     */
    public int getTotalPoints() {
        return timeBonus + milesBonus;
    }

    /**
     * Returns total time passed thus far.
     * @return
     */
    public int getTotalTime() {
        return minutesPassed;
    }

}
