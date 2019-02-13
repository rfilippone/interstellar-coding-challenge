package com.interstellar.codingchallenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.ChannelMapUnsupported;

@Service
public class ImageProcessorFactory {

  @Autowired
  VisibleProcessor visible;

  @Autowired
  VegetationProcessor vegetation;

  @Autowired
  WaterVaporProcessor waterVapor;

  public ImageProcessor forRequest(ImageGenerationRequest request) throws ChannelMapUnsupported {
    switch (request.getChannelMap()) {
    case "visible":
      return visible;

    case "vegetation":
      return vegetation;

    case "waterVapor":
      return waterVapor;

    default:
      throw new ChannelMapUnsupported();
    }
  }
}
