package com.interstellar.codingchallenge.domain;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class ImageGenerationServiceTests {
  private ImageGenerationService service;

  @Mock
  private GranuleFinder finder;

  @Before
  public void before() {
    service = new ImageGenerationService(finder);
  }

  @Test(expected = NotEnoughImages.class)
  public void throwsNotEnoughImagesOnMissingImages() throws ParseException, NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    when(finder.findGranule(request)).thenThrow(new NotEnoughImages());

    byte[] res = service.generateImage(request);
  }

}
