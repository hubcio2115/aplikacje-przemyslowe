package zad02;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Compute {
  public enum TypeOfCompute {
    MEAN,
    STANDARD_DEVIATION,
    VARIANCE;
  }

  public static double calculate(double[] values, TypeOfCompute type) {
    var stats = new DescriptiveStatistics();

    for (var value : values) stats.addValue(value);

    switch (type) {
      case MEAN:
        return stats.getMean();
      case VARIANCE:
        return stats.getVariance();
      case STANDARD_DEVIATION:
        return stats.getStandardDeviation();
      default:
        return 0;
    }
  }
}
