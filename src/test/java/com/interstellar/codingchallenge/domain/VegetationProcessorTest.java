package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class VegetationProcessorTest {

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessEmptyGranule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(new ArrayList<>());
    VegetationProcessor processor = new VegetationProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB05Granule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B06.tif"), new File("T33UUP_20180804T100031_B07.tif")));
    VegetationProcessor processor = new VegetationProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB06Granule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B05.tif"), new File("T33UUP_20180804T100031_B07.tif")));
    VegetationProcessor processor = new VegetationProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB07Granule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B05.tif"), new File("T33UUP_20180804T100031_B06.tif")));
    VegetationProcessor processor = new VegetationProcessor();
    processor.process(granule);
  }
}
