/*
   Author: Mike O'Malley
   Description: Graph of Current in Circuit
   My solution

   Structured Fortran 77 for Engineers and Scientists,
   D. M. Etter.
   (C) 1983.  ISBN: 0-8053-2520-4

My old QIT (Uni) textbook from my uni days 1983-1987 - VERY weather beaten and worn now (almost 30 years later).


Sample output:

          minValue= -9.999934600482855E-10
          maxValue= 8.417808198075109E-5
     rangeOfValues= 8.417908197421115E-5
    maxLabelLength= 0
      maxBarLength= 78
      originOffset= 9.999934600482855E-10
scaledOriginOffset= 0
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|
|*
|**
|***
|*******
|*************
|***********************
|******************************************
|*****************************************************************************

*/
public class Ch05_Q28__PNJunctionDiodeCurrentVoltageCurrent
{
   public static void main (String [] args)
   {
      // Constants:
      final double electronCharge     = 1.80E-19;  // Coulombs,
      final double BoltzmannsConstant = 1.38E-23; // joule / K  (K = degrees Kelvin)
      final double e                  = 2.718281828;

      double currentDiode         =  0.0; // Current through the Diode.  Amps.
      //double voltageDiode         =  0.0; // Voltage across the Diode. Volts.
      double saturationCurrent    =  1.0E-9; // Amps
      double junctionTemperatureK =  0.0; // in degrees Kelvin.
      double junctionTemperatureF = 32.0; // in degrees Farenheit. Values to use: 32, 100, 212.

      double voltageStart     = -0.250; // Voltage across the Diode. Volts.
      double voltageEnd       =  0.250; // Volts.
      double voltageIncrement =  0.0125; // Volts.
      double expValue         =  0.0;
      double voltage          =  voltageStart;

      int numValuesToPlot = (int) ((voltageEnd - voltageStart) / voltageIncrement);

      final double valuesArray [] = new double [numValuesToPlot];

      junctionTemperatureK = (((junctionTemperatureF - 32.0) * 5.0 / 9.0) + 273.16);

      for (int k = 0; k < numValuesToPlot; k++)
      {
         expValue = electronCharge * voltage / (BoltzmannsConstant * junctionTemperatureK);

         currentDiode = saturationCurrent * (Math.pow (e, expValue) - 1.0);

         valuesArray [k] = currentDiode;

         voltage = voltage + voltageIncrement;
      }

      System.out.println (BarGraph_Horizontal.BarGraph (valuesArray, null,        ' ', false));


   }
}