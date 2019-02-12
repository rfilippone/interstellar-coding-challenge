package com.interstellar.codingchallenge.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.interstellar.codingchallenge.domain.exception.ChannelMapUnsupported;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ImageProcessorFactoryTest {

  @Autowired
  private ImageProcessorFactory factory;

  @Test(expected = ChannelMapUnsupported.class)
  public void unsupportedChannelMap() throws ParseException, ChannelMapUnsupported {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "unsupported");
    factory.forRequest(request);
  }

}