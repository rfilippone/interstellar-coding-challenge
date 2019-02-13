package com.interstellar.codingchallenge.domain;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.ChannelMapUnsupported;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class ImageGenerationService {

  private GranuleFinder finder;
  private ImageProcessorFactory factory;

  @Autowired
  public ImageGenerationService(GranuleFinder finder, ImageProcessorFactory factory) {
    this.finder = finder;
    this.factory = factory;
  }

  public byte[] generateImage(ImageGenerationRequest request)
      throws NotEnoughImages, ChannelMapUnsupported, IOException {
    Granule granule = finder.findGranule(request);

    ImageProcessor processor = factory.forRequest(request);
    return processor.process(granule);
  }

}
