package com.interstellar.codingchallenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.ChannelMapUnsupported;

@Service
public class ImageProcessorFactory {

  @Autowired
  VisibleProcessor visible;

  public ImageProcessor forRequest(ImageGenerationRequest request) throws ChannelMapUnsupported {
    if (request.getChannelMap() == "visible") {
      return visible;
    }
    throw new ChannelMapUnsupported();
  }
}
