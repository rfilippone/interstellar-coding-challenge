package com.interstellar.codingchallenge.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.interstellar.codingchallenge.domain.Granule.Bands;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@RunWith(SpringRunner.class)
public class GranuleFinderTest {

  @Test(expected = NotEnoughImages.class)
  public void throwsWhenNoData() throws ParseException, NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    GranuleFinder finder = new GranuleFinder("test-data/empty");

    Granule granule = finder.findGranule(request);
  }

  @Test
  public void returnsGranuleWhen1FileAvailable() throws ParseException, NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    GranuleFinder finder = new GranuleFinder("test-data/1file");

    Granule granule = finder.findGranule(request);

    assertFalse(granule.has(Bands.B02));
  }

  @Test
  public void returnsCompleteGranuleWhenAllFilesAvailable() throws ParseException, NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    GranuleFinder finder = new GranuleFinder("test-data/complete");

    Granule granule = finder.findGranule(request);

    assertTrue(granule.has(Bands.B02));
    assertTrue(granule.has(Bands.B03));
    assertTrue(granule.has(Bands.B04));
    assertTrue(granule.has(Bands.B05));
    assertTrue(granule.has(Bands.B06));
    assertTrue(granule.has(Bands.B07));
    assertTrue(granule.has(Bands.B09));
  }

}
