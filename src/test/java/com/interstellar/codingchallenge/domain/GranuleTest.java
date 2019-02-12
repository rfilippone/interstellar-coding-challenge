package com.interstellar.codingchallenge.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GranuleTest {

  @Test
  public void providesNoBandsWhenNoFiles() {
    Granule granule = Granule.fromfiles(new ArrayList<>());
    assertFalse(granule.has(Granule.Bands.B02));
    assertFalse(granule.has(Granule.Bands.B03));
    assertFalse(granule.has(Granule.Bands.B04));
    assertFalse(granule.has(Granule.Bands.B05));
    assertFalse(granule.has(Granule.Bands.B06));
    assertFalse(granule.has(Granule.Bands.B07));
    assertFalse(granule.has(Granule.Bands.B09));
  }

  @Test
  public void providesB02IfPresent() {
    Granule granule = Granule.fromfiles(
        Arrays.asList(new File("T33UUP_20180804T100031_B01.tif"), new File("T33UUP_20180804T100031_B02.tif")));
    assertTrue(granule.has(Granule.Bands.B02));
    assertFalse(granule.has(Granule.Bands.B03));
    assertFalse(granule.has(Granule.Bands.B04));
    assertFalse(granule.has(Granule.Bands.B05));
    assertFalse(granule.has(Granule.Bands.B06));
    assertFalse(granule.has(Granule.Bands.B07));
    assertFalse(granule.has(Granule.Bands.B09));
  }

}
