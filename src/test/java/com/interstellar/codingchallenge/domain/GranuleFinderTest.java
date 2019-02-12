package com.interstellar.codingchallenge.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class GranuleFinderTest {

  @Test(expected = NotEnoughImages.class)
  public void test() throws ParseException, NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    GranuleFinder finder = new GranuleFinder();
    Granule granule = finder.findGranule(request);
  }
}
