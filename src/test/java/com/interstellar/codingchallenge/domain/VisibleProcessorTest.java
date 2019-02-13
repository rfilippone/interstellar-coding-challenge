package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class VisibleProcessorTest {

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessEmptyGranule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(new ArrayList<>());
    VisibleProcessor processor = new VisibleProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB02Granule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B03.tif"), new File("T33UUP_20180804T100031_B04.tif")));
    VisibleProcessor processor = new VisibleProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB03Granule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B02.tif"), new File("T33UUP_20180804T100031_B04.tif")));
    VisibleProcessor processor = new VisibleProcessor();
    processor.process(granule);
  }

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessMissingB04Granule() throws NotEnoughImages, IOException {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B02.tif"), new File("T33UUP_20180804T100031_B03.tif")));
    VisibleProcessor processor = new VisibleProcessor();
    processor.process(granule);
  }
}
