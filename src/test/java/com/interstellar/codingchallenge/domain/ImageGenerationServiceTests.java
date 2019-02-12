package com.interstellar.codingchallenge.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class ImageGenerationServiceTests {

  @Test(expected = NotEnoughImages.class)
  public void throwsNotEnoughImagesOnMissingImages() throws ParseException, NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    ImageGenerationService service = new ImageGenerationService();
    byte[] res = service.generateImage(request);
  }

}
