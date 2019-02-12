package com.interstellar.codingchallenge.domain;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class ImageGenerationService {

  public byte[] generateImage(ImageGenerationRequest request) throws NotEnoughImages {
    throw new NotEnoughImages();
  }

}
