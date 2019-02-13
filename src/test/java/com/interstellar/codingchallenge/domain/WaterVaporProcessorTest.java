package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class WaterVaporProcessorTest {

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessEmptyGranule() throws NotEnoughImages {
    Granule granule = Granule.fromfiles(new ArrayList<>());
    WaterVaporProcessor processor = new WaterVaporProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB09Granule() throws NotEnoughImages {
    Granule granule = Granule.fromfiles(Arrays.asList(new File("T33UUP_20180804T100031_B01.tif")));
    WaterVaporProcessor processor = new WaterVaporProcessor();
    processor.process(granule);
  }
}
