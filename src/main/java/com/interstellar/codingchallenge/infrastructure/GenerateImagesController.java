package com.interstellar.codingchallenge.infrastructure;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interstellar.codingchallenge.domain.ImageGenerationRequest;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@RestController
public class GenerateImagesController {

  @RequestMapping(method = RequestMethod.POST, path = "/generate-images")
  public void generateImages(@RequestBody ImageGenerationRequest request) throws NotEnoughImages {
    throw new NotEnoughImages();
  }
}
