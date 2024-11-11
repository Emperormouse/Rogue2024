package org.firstinspires.ftc.teamcode.subsystems;

public class PID_Placeholder {
    double kP, kI, kD;
    /**
     *
     * @param kP used for moving arm to its desired position
     * @param kI adjusts for a unchanging variable, such as gravity
     * @param kD adjusts for a random variable, like a bot bumping into yours
     *         (KD is VERY sensitive compared to the other two)
     */
    public PID_Placeholder(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }
    private double prevTime =  Double.NaN;
    private double lastError = 0, integError = 0;
    //Limits of the part (such as max/min speed)
    private double minLim = 0, maxLim = 0;
    /**
     *
     * @param target The desired value the arm wants to match
     * @param pos The current position of the arm
     * @param time The current time (Just pass '1' into it since it's being constantly ran)
     * @return - Returns the result of the PID
     */
    public double PID(int target, int pos, int time) {
        final double error = target - pos;
        final double dt = (prevTime != Double.NaN) ?
                (double)(time - prevTime) : 0;

        //Derivative and integral error
        final double derivError = (dt != 0) ? ((error - lastError) / dt) : 0;
        integError += error * dt;

        prevTime = time;
        lastError = error;

        return checkLims((kP * error) + (kI * integError) + (kD * derivError));
    }

    /**
     *
     * @param output - The output for the PID.
     * @return - If the output is less than the minimum limit, it will return the min.
     * if greater than the maximum limit, it will return the max.
     */
    private double checkLims(final double output){
        if (!Double.isNaN(minLim) && output < minLim)
            return minLim;
        else if (!Double.isNaN(maxLim) && output > maxLim)
            return maxLim;
        else
            return output;
    }

    public void setLims(final double minLim, final double maxLim) {
        if(minLim < maxLim) {
            this.minLim = minLim;
            this.maxLim = maxLim;
        }else{
            this.minLim = maxLim;
            this.maxLim = minLim;
        }

    }
}
