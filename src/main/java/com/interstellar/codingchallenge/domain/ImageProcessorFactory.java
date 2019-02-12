package com.interstellar.codingchallenge.domain;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.ChannelMapUnsupported;

@Service
public class ImageProcessorFactory {

  public ImageProcessor forRequest(ImageGenerationRequest request) throws ChannelMapUnsupported {
    throw new ChannelMapUnsupported();
  }
}
