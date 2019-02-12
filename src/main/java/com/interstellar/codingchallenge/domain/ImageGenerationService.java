package com.interstellar.codingchallenge.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class ImageGenerationService {

  private GranuleFinder finder;

  @Autowired
  public ImageGenerationService(GranuleFinder finder) {
    this.finder = finder;
  }

  public byte[] generateImage(ImageGenerationRequest request) throws NotEnoughImages {
    Granule granule = finder.findGranule(request);

    return null;
  }

}
