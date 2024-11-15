// THIS IS JUST A JOKE CLASS. DO NOT TAKE SERIOUSLY, LOL.
// THIS IS JUST A JOKE CLASS. DO NOT TAKE SERIOUSLY, LOL.
// THIS IS JUST A JOKE CLASS. DO NOT TAKE SERIOUSLY, LOL.
// THIS IS JUST A JOKE CLASS. DO NOT TAKE SERIOUSLY, LOL.
// THIS IS JUST A JOKE CLASS. DO NOT TAKE SERIOUSLY, LOL.
package org.firstinspires.ftc.teamcode.opModes.teleOp;
import static java.lang.Math.*;
public class SecretWeapon {
    private int levelOfUnfairness;
    public SecretWeapon(int lOU) {
        this.levelOfUnfairness = lOU;
    }

    public void ActivateWeapon() {
        for(int i = 0; i < levelOfUnfairness; i++)
            InitiateNuclearFusion(6);
    }

    /** Starts the secret weapon's secret weapon
     *
     * @param FusionCores How many cores for nuclear fusion is has
     */
    public void InitiateNuclearFusion(int FusionCores)
    {
        int hydrogenFusionReactions = 1;
        for(int i = 0; i < FusionCores * 5; i++) {
            hydrogenFusionReactions *= 2;
        }
        Explode explode = new Explode(FusionCores * 5);
        explode.DestroyStuff();
        explode.Fallout();
        explode.HideEvidence();
    }
}


class Explode {
    /** Makes robot go BIG BOOM
     *
     * @param blastYield Strength in Megatons of TNT
     */
    int power;
    Explode(int blastYield) {
        this.power = blastYield;
    }

    public void Fallout() {
        double gammaRays = power * pow(10,9);
    }

    public void DestroyStuff()
    {
        int blastRadiusKM = power * 10;
    }

    public void HideEvidence()
    {
        System.out.println("Don't disqualify us! We're not the ones who started the fusion reaction!");
    }
}
