package com.interstellar.codingchallenge.domain;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.interstellar.codingchallenge.domain.exception.ChannelMapUnsupported;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@RunWith(MockitoJUnitRunner.class)
public class ImageGenerationServiceTests {
  private ImageGenerationService service;

  @Mock
  private GranuleFinder finder;

  @Mock
  private ImageProcessorFactory factory;

  @Before
  public void before() {
    service = new ImageGenerationService(finder, factory);
  }

  @Test(expected = NotEnoughImages.class)
  public void throwsNotEnoughImagesOnMissingImages() throws ParseException, NotEnoughImages, ChannelMapUnsupported {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    when(finder.findGranule(request)).thenThrow(new NotEnoughImages());

    byte[] res = service.generateImage(request);
  }

}
